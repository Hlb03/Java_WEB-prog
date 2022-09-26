package file_manipulations.file_search;
/*
  User: admin
  Cur_date: 26.09.2022
  Cur_time: 14:31
*/

import file_manipulations.util.SortByAsciiCode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SearchTxtFiles implements Runnable {

    private final File file;
    private final List<File> allFiles;

    public SearchTxtFiles(File file, List<File> allFiles) {
        this.file = file;
        this.allFiles = allFiles;
    }

    @Override
    public void run() {
        System.out.println("\nNew thread was started");

        if (file == null) {
            System.out.println("Can't search files on 'null' value");
            return;
        }

        if (!file.isDirectory()) {
            System.out.println(file.getName() + " is not a directory");
            return;
        }

        File[] filesInsideDir = file.listFiles();

        if (filesInsideDir != null) {
            for (File file : filesInsideDir) {
                if (!file.isDirectory() && file.getName().endsWith(".txt")) {

                    try {
                        SortByAsciiCode.changeFileDataToSortedAsciiSequence(file);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    allFiles.add(file);
                    System.out.println(file.getName() + " was sorted and added to list with all found .txt files");
                } else if (file.isDirectory()) {
                    Thread thread = new Thread(new SearchTxtFiles(file, allFiles));
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}