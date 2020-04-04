package Mp3Project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Mp3ProjectApp {

    public static void main(String[] args) throws Exception {
      checkArgument(args);
      ReadInFile readInFile = new ReadInFile();
      List<String> content = readInFile.readFile(args[0]);
      content.forEach(System.out::println);
    }

    public static void checkArgument(String[] argv) throws Exception {
      if(argv.length != 1){
        System.out.println("-----------------------------");
        System.out.println("Missing Argument");
        System.out.println("-----------------------------");
        throw new Exception();
      }
    }
}
