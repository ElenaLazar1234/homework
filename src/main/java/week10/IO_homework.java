package week10;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IO_homework {

    public static List<String> getAllFileNames(String pathName){
        List<String> fileNames = new ArrayList<>();
        try(DirectoryStream<Path> directoryStream  = Files.newDirectoryStream(Paths.get(pathName))) {
            for(Path path : directoryStream) {
                fileNames.add(path.toString());
            }
            return fileNames;
        }
        catch(IOException ex) {
            return fileNames;
        }
    }
    public static void main (String [] args){
        List<String> files = getAllFileNames("C:/Users/Elena Lazar/workspace/homework/src/main/resources");
        for(String fileName : files){
            System.out.println((fileName));
        }
    }
}
