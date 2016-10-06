import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.sql2o.*;

public class Animal {
  public String species;
  public int id;
  public int health;
  public int age;
  public int gender;
  public boolean endangered;

  public Animal(String species, int health, int age, int gender, boolean endangered) {
    this.species = species;
    this.health = health;
    this.age = age;
    this.gender = gender;
    this.endangered = endangered;
  }

  public String getSpecies() {
    return species;
  }

  public boolean getEndangered() {
    return endangered;
  }

  public int getId() {
    return id;
  }

  public int getHealth() {
    return health;
  }

  public int getAge() {
    return age;
  }

  public int getGender() {
    return gender;
  }

}
