package Mp3Project;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

class ReadInFile {

  void readFile(String path) throws Exception {
    if(validateFilePath(path)){
      Path pathFile = Paths.get(path);
      
    } else {
      throw new Exception();
    }
  }

  private boolean validateFilePath(String path) {
    Path pathFile = Paths.get(path);
    return Files.exists(pathFile, LinkOption.NOFOLLOW_LINKS);
  }
}