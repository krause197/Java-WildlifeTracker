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
        .addParameter("species", species)
        .addParameter("health", health)
        .addParameter("age", age)
        .addParameter("gender", gender)
        .addParameter("endangered", endangered)
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

  public int getHealthid() {
    return health;
  }

  public int getAgeid() {
    return age;
  }

  public int getGenderid() {
    return gender;
  }

  @Override
    public boolean equals(Object otherObject) {
      if (!(otherObject instanceof Animal)) {
        return false;
      } else {
        Animal newAnimal = (Animal) otherObject;
        return newAnimal.getId() == this.id;
      }
    }

  public static List<String> allSpecies(){
  try(Connection con = DB.sql2o.open()){
    String sql = "SELECT species FROM animals;";
    return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(String.class);
  }
}

  public String findSpecies(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT species FROM animals WHERE id=:id;";
      String species = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(String.class);
      return species;
    }
  }

    public static Animal find(int id) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT * FROM animals WHERE id=:id;";
        Animal animal = con.createQuery(sql)
          .addParameter("id", id)
          .executeAndFetchFirst(Animal.class);
        return animal;
      }
    }

    public static List<String> allHealth(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM health;";
      return con.createQuery(sql)
        .throwOnMappingFailure(false)
        .executeAndFetch(String.class);
    }
  }

    public static Animal findHealth(int healthid) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT * FROM health WHERE id=:healthid;";
        Animal health = con.createQuery(sql)
          .addParameter("healthid", healthid)
          .executeAndFetchFirst(Animal.class);
        return health;
      }
    }

    public static List<String> allAge(){
      try(Connection con = DB.sql2o.open()){
        String sql = "SELECT * FROM age;";
        return con.createQuery(sql)
          .throwOnMappingFailure(false)
          .executeAndFetch(String.class);
    }
  }
    public static Animal findAge(int ageid) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT * FROM age WHERE id=:ageid;";
        Animal age = con.createQuery(sql)
          .addParameter("ageid", ageid)
          .executeAndFetchFirst(Animal.class);
        return age;
      }
    }

    public static List<String> allGender(){
      try(Connection con = DB.sql2o.open()){
        String sql = "SELECT gender FROM animals;";
        return con.createQuery(sql)
          .throwOnMappingFailure(false)
          .executeAndFetch(String.class);
    }
  }

    public static Animal findGender(int genderid) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT gender FROM animals WHERE id=:genderid;";
        Animal gender = con.createQuery(sql)
          .addParameter("genderid", genderid)
          .executeAndFetchFirst(Animal.class);
        return gender;
      }
    }

    public void update(){
      try(Connection con = DB.sql2o.open()){
        String sql = "UPDATE animals SET species=:species, health=:health, age=:age, gender=:gender, endangered=:endangered  WHERE id=:id";
        con.createQuery(sql)
          .addParameter("species", this.species)
          .addParameter("health", this.health)
          .addParameter("age", this.age)
          .addParameter("gender", this.gender)
          .addParameter("endangered", this.endangered)
          .executeUpdate();
      }
    }

    public void delete(){
      try(Connection con = DB.sql2o.open()){
        String sql = "DELETE FROM animals WHERE id=:id";
        con.createQuery(sql)
          .addParameter("id", this.id)
          .executeUpdate();
      }
    }



}
