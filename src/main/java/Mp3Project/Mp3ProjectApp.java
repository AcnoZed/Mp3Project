package Mp3Project;

import java.nio.file.Path;

public class Mp3ProjectApp {

    public static void main(String[] args) throws Exception {

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
