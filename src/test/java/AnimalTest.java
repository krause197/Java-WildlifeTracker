import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;


public class AnimalTest {

  // Animal animalAlpha = new Animal("Wolf", 1, 3, 1, true);
  // Animal animalBravo = new Animal("Brown Bear", 1, 4, 2, false);

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiates_true() {
    Animal animalAlpha = new Animal("Wolf", 1, 3, 1, true);
    assertEquals(true, animalAlpha instanceof Animal);
  }

  @Test
  public void getSpecies_retrievesCorrectSpeciesName_Wolf() {
    Animal animalAlpha = new Animal("Wolf", 1, 3, 1, true);
    assertEquals("Wolf", animalAlpha.getSpecies());
  }

  @Test
  public void getEndangered_returnsBoolean_True() {
    Animal animalAlpha = new Animal("Wolf", 1, 3, 1, true);
    assertTrue(animalAlpha.getEndangered());
  }

  @Test
  public void getHealthid_returnsHealthID_1() {
    Animal animalAlpha = new Animal("Wolf", 1, 3, 1, true);
    assertEquals(1, animalAlpha.getHealthid());
  }

  @Test
  public void getAgeid_returnAgeID_3() {
    Animal animalAlpha = new Animal("Wolf", 1, 3, 1, true);
    assertEquals(3, animalAlpha.getAgeid());
  }

  @Test
  public void getGenderid_returnGenderId_1(){
    Animal animalAlpha = new Animal("Wolf", 1, 3, 1, true);
    assertEquals(1, animalAlpha.getGenderid());
  }
}
