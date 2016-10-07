import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class SightingTest {

  Sighting sightingAlpha = new Sighting(1, 2, 2, "eating grass");
  Sighting sightingBravo = new Sighting(2, 1, 3, "foraging");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Sighting_instantiates_true() {
    Sighting testSighting = sightingAlpha;
    assertEquals(true, testSighting instanceof Sighting);
  }

  @Test
  public void getName_returnsCorrectAnimalID_1() {
    Sighting testSighting = sightingAlpha;
    assertEquals(2, testSighting.getAnimalId());
  }

  @Test
  public void getRangerId_returnsCorrectRangerId_2() {
    Sighting testSighting = sightingAlpha;
    assertEquals(1, testSighting.getRangerId());
  }

  @Test
  public void getLocationId_returnsLocationId_2() {
    Sighting testSighting = sightingAlpha;
    assertEquals(2, testSighting.getLocationId());
  }

  @Test
  public void getNotes_returnsNotes_eatinggrass() {
    Sighting testSighting = sightingAlpha;
    assertEquals("eating grass", testSighting.getNotes());
  }
  @Test
  public void save_recordsTimeOfCreationInDatabase_true() {
    Sighting testSighting = sightingAlpha;
    String savedSightingTime = Sighting.find(testSighting.getId()).getSighting_date();
    assertEquals(savedSightingTime, "October 07, 2016");
    // Must insert current day's date in assertEquals statement to pass test
  }
}
