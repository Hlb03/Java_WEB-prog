package file_manipulations;
/*
  User: admin
  Cur_date: 26.09.2022
  Cur_time: 10:45
*/

import file_manipulations.file_search.SearchTxtFiles;
import file_manipulations.util.FileWriteToAnotherDir;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    // C:\Users\admin\OneDrive\Рабочий стол\KPI_studying\V semestr\Java web-programming\Lab_1\File_dir_not_sorted
    // C:\Users\admin\OneDrive\Рабочий стол\KPI_studying\V semestr\Java web-programming\Lab_1\File_sorted

    private final static List<File> allFiles = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a directory to explore: ");
        String directory = scanner.nextLine();

        Thread searchTxtFilesThread = new Thread(new SearchTxtFiles(new File(directory), allFiles));
        searchTxtFilesThread.start();
        searchTxtFilesThread.join();

        System.out.print("\nEnter a directory where to write files: ");
        String directoryToCopy = scanner.nextLine();

        FileWriteToAnotherDir.writeToAnotherDir(allFiles, new File(directoryToCopy));

        System.out.println("\nProgram was finished successfully");
       }
}