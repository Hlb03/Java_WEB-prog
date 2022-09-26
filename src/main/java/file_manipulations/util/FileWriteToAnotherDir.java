package file_manipulations.util;
/*
  User: admin
  Cur_date: 26.09.2022
  Cur_time: 16:02
*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FileWriteToAnotherDir {

    public static void writeToAnotherDir(List<File> files, File directory) throws IOException {

        if (!directory.isDirectory()){
            System.out.println(directory.getName() + " is not a directory. Failed to copy");
            return;
        }

        for (File file : files) {
            Files.copy(file.toPath(), Paths.get(directory.toPath() + "\\" + file.getName()),
                    StandardCopyOption.REPLACE_EXISTING);
        }

        System.out.println("Files were successfully written");
    }
}