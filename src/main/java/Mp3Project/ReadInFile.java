package Mp3Project;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ReadInFile {

  List<Path> readFile(String fileDirectory) throws Exception {
    List<Path> files = new ArrayList<>();
    if(validateFilePath(fileDirectory)){
      Path path = Paths.get(fileDirectory);
      try {
        DirectoryStream<Path> stream = Files.newDirectoryStream(path,"*.mp3");
        for(Path file: stream){
          files.add(file.getFileName());
        }
      }catch (IOException ignored){

      }
      return files;
    } else {
      System.out.println("-----------------------------");
      System.out.println("PathValidation failed!");
      System.out.println("-----------------------------");
      throw new Exception("The specified directory does not exist : " + fileDirectory);
    }
  }

  private boolean validateFilePath(String fileDirectory) {
    Path path = Paths.get(fileDirectory);
    return Files.exists(path, LinkOption.NOFOLLOW_LINKS);
  }
}