package exercise;

import java.util.concurrent.CompletableFuture;
//import java.util.Arrays;
//import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
//import java.io.File;
//import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathName1, String pathName2, String pathNameResult) {
        CompletableFuture<String> read1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(pathName1));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("NoSuchFileException");
                return null;
            }
        });

        CompletableFuture<String> read2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(pathName2));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("NoSuchFileException");
                return null;
            }
        });

        CompletableFuture<String> write1 = read1.thenCombine(read2, (content1, content2) -> {
            String combined = content1 + content2;
            try {
                Files.writeString(Path.of(pathNameResult), combined);
                return combined;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
        write1.join();
        return write1;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/dest.txt"
        );
        System.out.println(result);
        // END
    }
}

