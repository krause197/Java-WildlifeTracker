import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class AnimalTest {

  Animal animalAlpha = new Animal("Wolf", 1, 3, 1, true);
  Animal animalBravo = new Animal("Brown Bear", 1, 4, 2, false);

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiates_true() {
    Animal testAnimal = animalAlpha;
    assertEquals(true, testAnimal instanceof Animal);
  }

}
