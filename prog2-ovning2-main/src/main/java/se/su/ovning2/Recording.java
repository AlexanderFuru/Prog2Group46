package se.su.ovning2;

import java.util.Collection;
import java.util.Set;

public class Recording implements Comparable<Recording>{
  private final int year;
  private final String artist;
  private final String title;
  private final String type;
  private final Set<String> genre;

  public Recording(String title, String artist, int year, String type, Set<String> genre) {
    this.title = title;
    this.year = year;
    this.artist = artist;
    this.type = type;
    this.genre = genre;
  }

  public String getArtist() {
    return artist;
  }

  public Collection<String> getGenre() {
    return genre;
  }

  public String getTitle() {
    return title;
  }

  public String getType() {
    return type;
  }

  public int getYear() {
    return year;
  }

public boolean equals(Object other){
  if (other instanceof Recording r)
    return r.year == this.year && r.title.equals(this.title) && r.artist.equals(this.artist);

  else
    return false;
}

@Override
public int hashCode(){
  return Objects.hash(year, artist, title);
}

@Override
public int compareTo(Recording o){
  if (year > o.year)
    return 1;

  else if (year < o.year)
    return -1;

  else if ()
    return 

  else if ()
    return
      
  else if ()
    return

  else if ()
    return
}

  @Override
  public String toString() {
    return String.format("{ %s | %s | %s | %d | %s }", artist, title, genre, year, type);
  }
}
