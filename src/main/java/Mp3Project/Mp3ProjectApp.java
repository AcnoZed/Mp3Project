package Mp3Project;

import static java.sql.DriverManager.*;

import Mp3Project.model.Audio;
import java.sql.Connection;
import java.util.List;

public class Mp3ProjectApp {

    public static void main(String[] args) throws Exception {
      checkArgument(args);
      ReadInFile readInFile = new ReadInFile();
      List<Audio> content = readInFile.readFile(args[0]);
      content.forEach(System.out::println);

      try (Connection conn =
          getConnection("jdbc:h2:./../../../mydatabase;AUTO_SERVER=TRUE;"
              + "INIT=runscript from './../../resources/data/create.sql'")) {
      }
    }

    private static void checkArgument(String[] argv) throws Exception {
      if(argv.length != 1){
        throw new Exception("You need to specify a valid mp3 directory");
      }
    }
}
