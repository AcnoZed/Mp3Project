package Mp3Project.model;

import lombok.Getter;

@Getter
public class Audio {
  private String artist;
  private String year;
  private String album;
  private String title;

  public Audio(String artist, String year, String album, String title) {
    this.artist = artist;
    this.year = year;
    this.album = album;
    this.title = title;
  }


}
