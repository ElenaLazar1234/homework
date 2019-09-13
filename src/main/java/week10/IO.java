package week10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IO {

    public static void main(String[] args) {
       //  System.out.println("1.get a list of all file/directory names from the given");
        // getAllFileNames("C:/Users/Elena Lazar/workspace/homework/src/main/java", true);
        getSpecificFiles("C:/Users/Elena Lazar/workspace/homework/src/main/java/week1");
    }

    public static void getAllFileNames(String path, boolean isDirectory) {


        try (Stream<Path> fileNames = Files.walk(Paths.get(path))) {
            if (isDirectory) {
                fileNames
                        .filter(Files::isDirectory)
                        .map(a -> a.getFileName().toString()).collect(Collectors.toList())
                        .forEach(System.out::println);
            } else {
                fileNames
                        .filter(Files::isRegularFile)
                        .map(a -> a.getFileName().toString()).collect(Collectors.toList())
                        .forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getSpecificFiles(String path){
       try( Stream<Path> Extensions = Files.walk(Paths.get(path))){
           Extensions
                   .filter(a->a.endsWith("java"))
                   .forEach(b->System.out.println(b.getFileName().toString()));


       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    public static void checkIfaFileExists(String path){
        try(boolean  ExistingFiles = Files.exists(path)) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
