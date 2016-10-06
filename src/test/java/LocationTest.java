import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LocationTest {

  Location locationAlpha = new Location("Pine Meadow", "AB 9780 2345");
  Location locationBravo = new Location("Black Forest", "AB 9732 2356");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Location_instantiates_true() {
    Location testLocation = locationAlpha;
    assertEquals(true, testLocation instanceof Location);
  }

  @Test
  public void getName_returnsCorrectName_PineMeadow() {
    Location testLocation = locationAlpha;
    assertEquals("Pine Meadow", testLocation.getName());
  }

  @Test
  public void getMgrs_returnsCorrectGridCoord_AB97802345() {
    Location testLocation = locationAlpha;
    assertEquals("AB 9780 2345", testLocation.getMgrs());
  }

  @Test
  public void find_returnsLocation_locationAlpha() {
    Location testLocation = locationAlpha;
    int locationId = testLocation.getId();
    assertEquals("Pine Meadow", "AB 9780 2345", testLocation.find(locationId));
  }
}
