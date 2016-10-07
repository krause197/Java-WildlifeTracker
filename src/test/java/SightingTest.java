import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class SightingTest {

  // Sighting sightingAlpha = new Sighting(1, 2, 2, "eating grass");
  // Sighting sightingBravo = new Sighting(2, 1, 3, "foraging");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Sighting_instantiates_true() {
    Sighting sightingAlpha = new Sighting(1, 2, 2, "eating grass");
    assertEquals(true, sightingAlpha instanceof Sighting);
  }

  @Test
  public void getName_returnsCorrectAnimalID_1() {
    Sighting sightingAlpha = new Sighting(1, 2, 2, "eating grass");
    assertEquals(2, sightingAlpha.getAnimalId());
  }

  @Test
  public void getRangerId_returnsCorrectRangerId_2() {
    Sighting sightingAlpha = new Sighting(1, 2, 2, "eating grass");
    assertEquals(1, sightingAlpha.getRangerId());
  }

  @Test
  public void getLocationId_returnsLocationId_2() {
    Sighting sightingAlpha = new Sighting(1, 2, 2, "eating grass");
    assertEquals(2, sightingAlpha.getLocationId());
  }

  @Test
  public void getNotes_returnsNotes_eatinggrass() {
    Sighting sightingAlpha = new Sighting(1, 2, 2, "eating grass");
    assertEquals("eating grass", sightingAlpha.getNotes());
  }
} 
//   @Test
//   public void save_savestodatabase_true() {
//     Sighting sightingAlpha = new Sighting(1, 2, 2, "eating grass");
//     sightingAlpha.save();
//     assertEquals(true, Sighting.all().get(0).equals(sightingAlpha));
//   }
// }
