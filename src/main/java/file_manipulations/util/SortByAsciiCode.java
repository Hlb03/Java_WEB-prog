package file_manipulations.util;
/*
  User: admin
  Cur_date: 26.09.2022
  Cur_time: 17:12
*/

import java.io.*;

public class SortByAsciiCode {
    public static void changeFileDataToSortedAsciiSequence(File file) throws IOException {
        String data = readFile(file);
        writeInFile(file, data);
    }

    private static String readFile(File file) throws IOException {
        StringBuilder fileData = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String temp;
        while ((temp = reader.readLine()) != null)
            fileData.append(temp).append("\n");

        fileData.deleteCharAt(fileData.length() - 1);
        reader.close();

        return sortByAscii(fileData.toString());
    }

    private static void writeInFile(File f, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));

        writer.write(data);
        writer.close();
    }

    public static String sortByAscii(String string) {
        char[] chars = string.toCharArray();
//        Arrays.sort(chars);
        quickSort(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    private static void quickSort(char[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(char[] arr, int low, int high) {
        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}