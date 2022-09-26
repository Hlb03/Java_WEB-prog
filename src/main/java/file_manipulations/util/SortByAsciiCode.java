package file_manipulations.util;
/*
  User: admin
  Cur_date: 26.09.2022
  Cur_time: 17:12
*/

import java.io.*;
import java.util.Arrays;

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

    private static String sortByAscii(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);

        return String.valueOf(chars);
    }
}