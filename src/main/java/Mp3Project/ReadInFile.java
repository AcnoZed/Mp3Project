package Mp3Project;

import Mp3Project.model.Audio;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ReadInFile {

  List<Audio> readFile(String fileDirectory) throws Exception {
    List<Audio> files = new ArrayList<>();
    if(validateFilePath(fileDirectory)){
      Path path = Paths.get(fileDirectory);
      try {
        DirectoryStream<Path> stream = Files.newDirectoryStream(path,"*.mp3");
        for(Path file: stream){
          files.add(fillAudio(new Mp3File(file.toString())));
        }
      }catch (IOException e){
        throw new Exception(e);
      }
      return files;
    } else {
      throw new Exception("The specified directory does not exist : " + fileDirectory);
    }
  }
  private Audio fillAudio(Mp3File mp3File){
    if(mp3File.hasId3v1Tag()) {
      ID3v1 id3v1Tag = mp3File.getId3v1Tag();
      return new Audio(id3v1Tag.getArtist(),id3v1Tag.getYear(),id3v1Tag.getAlbum(),id3v1Tag.getTitle());
    } else {
      ID3v2 id3v2Tag = mp3File.getId3v2Tag();
      return new Audio(id3v2Tag.getArtist(),id3v2Tag.getYear(),id3v2Tag.getAlbum(),id3v2Tag.getTitle());
    }
  }

  private boolean validateFilePath(String fileDirectory) {
    Path path = Paths.get(fileDirectory);
    return Files.exists(path, LinkOption.NOFOLLOW_LINKS);
  }
}