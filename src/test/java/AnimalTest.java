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

  @Test
  public void getSpecies_retrievesCorrectSpeciesName_Wolf() {
    Animal testAnimal = animalAlpha;
    assertEquals("Wolf", testAnimal.getSpecies());
  }

  @Test
  public void getEndangered_returnsBoolean_True() {
    Animal testAnimal = animalAlpha;
    assertTrue(testAnimal.getEndangered());
  }

  @Test
  public void getHealth_returnsHealthID_1() {
    Animal testAnimal = animalAlpha;
    assertEquals(1, testAnimal.getHealth());
  }

  @Test
  public void getAge_returnAgeID_3() {
    Animal testAnimal = animalAlpha;
    assertEquals(3, testAnimal.getAge());
  }

  @Test
  public void getGender_returnGenderId_1(){
    Animal testAnimal = animalAlpha;
    assertEquals(1, testAnimal.getGender());
  }
}
