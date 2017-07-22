package Ex05_FilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class Pr08_GetFolderSize {
    public static void main(String[] args) throws IOException {

        String directoryPath = System.getProperty("user.dir");
        Path path = Paths.get(directoryPath);
        long size = getSize(path);
        System.out.println(size);

    }

    static long getSize(Path path) throws IOException {
        final AtomicLong size = new AtomicLong(0);

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes attrs) throws IOException {
                size.addAndGet(attrs.size());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc)
                    throws IOException {
                // Skip folders that can't be traversed
                System.out.println("skipped: " + file + "e=" + exc);
                return FileVisitResult.CONTINUE;
            }
        });

        return size.get();
    }
}

