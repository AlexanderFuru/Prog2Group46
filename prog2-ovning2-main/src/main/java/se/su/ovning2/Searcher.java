package se.su.ovning2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Comparator;
import java.util.SortedMap;

public class Searcher implements SearchOperations {

  private static class RecordingYearComparator implements Comparator<Recording>{
    @Override
    public int compare(Recording a, Recording b){
      return a.getYear() - b.getYear();
    }
    
  }
  private static Comparator RECORDING_BY_YEAR = new RecordingYearComparator();

  private final Map<String, Set<Recording>> artistToRecording = new HashMap<>();
  private final Map<String, Recording> titleToRecording = new HashMap<>();
  private final Map<String, Set<Recording>> genreToRecording = new HashMap<>();
  private final Set<Recording> allRecording = new HashSet<>();
  private final SortedMap<Integer, Set<Recording>> yearToRecording = new TreeMap<>();

  public Searcher(Collection<Recording> data) {
    for (Recording r : data){
      Set<Recording> sameArtist = artistToRecording.get(r.getArtist());

      if (sameArtist == null){
        sameArtist = new HashSet<>();
        artistToRecording.put(r.getArtist(), sameArtist);
      }
      sameArtist.add(r);
      titleToRecording.put(r.getTitle(), r);
      allRecording.add(r);

      for (String genre : r.getGenre()) {
        Set<Recording> sameGenre = genreToRecording.get(genre);
        if (sameGenre == null) {
          sameGenre = new HashSet<>();
          genreToRecording.put(genre, sameGenre);
        }
        sameGenre.add(r);
      }

      Set<Recording> sameYear = yearToRecording.get(r.getYear());
      if (sameYear == null) {
        sameYear = new HashMap<>();
        yearToRecording.put(year, sameYear);
      }
        
    }
  }

  @Override
  public long numberOfArtists() {
    return artistToRecording.size();
  }

  @Override
  public long numberOfGenres() {
    return genreToRecording.size();
  }

  @Override
  public long numberOfTitles() {
    return titleToRecording.size();
  }

  @Override
  public boolean doesArtistExist(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'doesArtistExist'");
  }

  @Override
  public Collection<String> getGenres() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getGenres'");
  }

  @Override
  public Recording getRecordingByName(String title) {
    return titleToRecording.get(title);
  }

  @Override
  public Collection<Recording> getRecordingsAfter(int year) {
    SortedMap<Integer, Set<Recording>> afterYear = yearToRecording.tailMap(year);
    Set<Recording> allAfter = new HashSet<>();
    for (Set<Recording> currentYear : afterYear.values())
      allAfter.addAll(currentYear);

    return Collections.unmodifiableSet(allAfter);
  }

  @Override
  public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist) {
    Set<Recording> sameArtist = artistToRecording.get(artist);
    if (sameArtist == null)
      return Collections.emptySortedSet();

    SortedSet<Recording> sortedRecording = new TreeSet<>(RECORDING_BY_YEAR);
    sortedRecording.addAll(sameArtist);
    return Collections.unmodifiableSortedSet(sortedRecording);
  }

  @Override
  public Collection<Recording> getRecordingsByGenre(String genre) {
    Set<Recording> sameGenre = genreToRecording.get(genre);
    if (sameGenre == null)
      return Collections.emptySet();

    return Collections.unmodifiableSet(sameGenre);
  }

  @Override
  public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearFrom, int yearTo) {
    Set<Recording> sameGenre = genreToRecording.get(genre);
    Set<Recording> betweenYear = new HashSet<>();
    
    for (Recording r : sameGenre) {
      int year = r.getYear();

      if (year < yearTo && year > yearFrom)
        betweenYear.add(r);
    }

    // Set<Recording> toReturn = new HashSet<>();
    // SortedMap<Integer, Set<Recording>> betweenYear = yearToRecording.subMap(yearFrom, yearTo + 1);

    // for (Set<Recording> recordings : betweenYear.values)
    //   for (Recording r : recordings)
    //     for (String g : r.getGenre())
    //       if (g.equals(genre))
    //         toReturn.add(r);
  }

  @Override
  public Collection<Recording> offerHasNewRecordings(Collection<Recording> offered) {
    Set<Recording> missing = new HashSet<>();
    for (Recording r : offered)
      if (!allRecording.contains(r))
        missing.add(r);

    return Collections.unmodifiableSet(missing);
  }
}
