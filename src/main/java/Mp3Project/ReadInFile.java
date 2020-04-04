package Mp3Project;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class ReadInFile {

  List<String> readFile(String path) throws Exception {
    if(validateFilePath(path)){
      Path pathFile = Paths.get(path);
      List<String> contents = Files.readAllLines(pathFile);
      return contents;
    } else {
      System.out.println("-----------------------------");
      System.out.println("PathValidation failed!");
      System.out.println("-----------------------------");
      throw new Exception();
    }
  }

  private boolean validateFilePath(String path) {
    Path pathFile = Paths.get(path);
    return Files.exists(pathFile, LinkOption.NOFOLLOW_LINKS);
  }
}