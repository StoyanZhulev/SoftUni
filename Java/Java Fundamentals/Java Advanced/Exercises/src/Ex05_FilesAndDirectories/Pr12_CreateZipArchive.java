package Ex05_FilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Pr12_CreateZipArchive {
    private final static String text1Path = "/Exercises/src/resources/text1Pr12.txt";
    private final static String text2Path = "/Exercises/src/resources/text2Pr12.txt";
    private final static String text3Path = "/Exercises/src/resources/text3Pr12.txt";


    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String text1 = projectPath + text1Path;
        String text2 = projectPath + text2Path;
        String text3 = projectPath + text3Path;
         String outputPath = projectPath + "/Exercises/src/resources/zippedFilesPr12.zip";


        try (FileOutputStream fileOutput = new FileOutputStream(outputPath);
             ZipOutputStream outputZipped = new ZipOutputStream(fileOutput)) {


            addFileToZip(outputZipped, text1);
            addFileToZip(outputZipped, text2);
            addFileToZip(outputZipped, text3);
        }
    }

    private static void addFileToZip(ZipOutputStream outputZipped, String pathToFile) throws IOException {
        try (FileInputStream fileInput = new FileInputStream(pathToFile)) {
            ZipEntry zipEntry = new ZipEntry(pathToFile);
            outputZipped.putNextEntry(zipEntry);
            byte[] buffer = new byte[4096];
            int byteReader;
            while ((byteReader = fileInput.read(buffer, 0, buffer.length)) >= 0) {
                outputZipped.write(byteReader);
            }

        }

    }
}
