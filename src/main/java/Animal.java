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

    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (species, health, age, gender, endangered) VALUES (:species, :health, :age, :gender, :endangered);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("species", this.species)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .addParameter("gender", this.gender)
        .addParameter("endangered", this.endangered)
        .executeUpdate()
        .getKey();

    }
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
