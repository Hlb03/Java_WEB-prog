package file_manipulations.util;
/*
  User: admin
  Cur_date: 26.09.2022
  Cur_time: 15:43
*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class FileSortBySizeUtil {

    public static void sortBySize(List<File> files) {
        files.sort(Comparator.comparing(size -> {
            try {
                return Files.size(Paths.get(size.getPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }
}
