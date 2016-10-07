import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LocationTest {

  // Location locationAlpha = new Location("Pine Meadow", "AB 9780 2345");
  // Location locationBravo = new Location("Black Forest", "AB 9732 2356");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Location_instantiates_true() {
    Location locationAlpha = new Location("Pine Meadow", "AB 9780 2345");
    assertEquals(true, locationAlpha instanceof Location);
  }
  //
  // @Test
  // public void getName_returnsCorrectName_PineMeadow() {
  //   Location locationAlpha = new Location("Pine Meadow", "AB 9780 2345");
  //   assertEquals("Pine Meadow", locationAlpha.getName());
  // }
  //
  // @Test
  // public void getMgrs_returnsCorrectGridCoord_AB97802345() {
  //   Location locationAlpha = new Location("Pine Meadow", "AB 9780 2345");
  //   assertEquals("AB 9780 2345", locationAlpha.getMgrs());
  // }
  //
  // @Test
  // public void find_returnsLocation_locationAlpha() {
  //   Location locationAlpha = new Location("Pine Meadow", "AB 9780 2345");
  //   int locationId = locationAlpha.getId();
  //   assertEquals("Pine Meadow", "AB 9780 2345", Location.find(locationId));
  // }
}
