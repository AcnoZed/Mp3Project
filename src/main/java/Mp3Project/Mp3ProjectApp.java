package Mp3Project;

import java.nio.file.Path;
import java.util.List;

public class Mp3ProjectApp {

    public static void main(String[] args) throws Exception {
      checkArgument(args);
      ReadInFile readInFile = new ReadInFile();
      List<Path> content = readInFile.readFile(args[0]);
      content.forEach(System.out::println);
    }

    private static void checkArgument(String[] argv) throws Exception {
      if(argv.length != 1){
        System.out.println("-----------------------------");
        System.out.println("You need to specify a valid mp3 directory");
        System.out.println("-----------------------------");
        throw new Exception();
      }
    }
}
