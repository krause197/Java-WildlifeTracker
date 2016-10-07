import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Sighting {
  private int id;
  private int animalid;
  private int rangerid;
  private int locationid;
  private Timestamp sighting_date;
  private String notes;

  public Sighting(int rangerid, int animalid, int locationid, String notes){
    this.animalid = animalid;
    this.rangerid = rangerid;
    this.locationid = locationid;
    this.sighting_date = sighting_date;
    this.notes = notes;

    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (rangerid, animalid, locationid, sighting_date, notes) VALUES (:rangerid, :animalid, :locationid, now(), :notes);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("animalid", animalid)
        .addParameter("rangerid", rangerid)
        .addParameter("locationid", locationid)
        .addParameter("notes", notes)
        .executeUpdate()
        .getKey();
    }

  }

  public int getId(){
    return id;
  }

  public int getAnimalId(){
    return animalid;
  }

  public int getRangerId(){
    return rangerid;
  }

  public int getLocationId(){
    return locationid;
  }

  public String getSighting_date(){
    return new SimpleDateFormat("MMMM dd, yyyy").format(this.sighting_date);
  }

  public String getNotes(){
    return this.notes;
  }

  // public String getRangerName(){
  //   Ranger ranger = Ranger.find(this.rangerid);
  //   return ranger.getName();
  // }

  public String getSpecies(){
    Animal animal = Animal.find(this.animalid);
    return animal.getSpecies();
  }


  public String getLocationName(){
    Location location = Location.find(this.locationid);
    return location.getName();
  }

  public void updateNotes(String notes){
    this.notes = notes;
    this.update();
  }

  @Override
  public boolean equals(Object otherObject){
    if(!(otherObject instanceof Sighting)){
      return false;
    }else{
      Sighting newSighting = (Sighting) otherObject;
      return newSighting.getId() == this.id;
    }
  }

  public static Sighting find(int _id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE id=:id";
      return con.createQuery(sql)
        .addParameter("id", _id)
        .executeAndFetchFirst(Sighting.class);
    }
  }

  public static List<Sighting> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings";
      return con.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }

  public List<Sighting> allAnimalSightings(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE animalid=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Sighting.class);
    }
  }

  public List<Sighting> allLocationSightings(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE locationid=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Sighting.class);
    }
  }

  public void update(){
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE sightings SET animalid=:animalid, rangerid=:rangerid, locationid=:locationid, sighting_date=:sighting_date, notes=:notes WHERE id=:id";
      con.createQuery(sql)
        .addParameter("animalid", this.animalid)
        .addParameter("rangerid", this.rangerid)
        .addParameter("locationid", this.locationid)
        .addParameter("sighting_date", this.sighting_date)
        .addParameter("notes", this.notes)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public void delete(){
    try(Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM sightings WHERE id=:id";
      con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }
}
