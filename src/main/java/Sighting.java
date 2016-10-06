import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Sighting {
  private int id;
  private int animalid;
  private int rangerid;
  private int location_d;
  private Timestamp sighting_date;
  private String notes;

  public Sighting (int animalid, int rangerid, int locationid, Timestamp sighting_date, String notes){
    this.animalid = animalid;
    this.rangerid = rangerid;
    this.locationid = locationid;
    this.sighting_date = sighting_date;
    this.notes = notes;

    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (animalid, rangerid, locationid, sighting_date, notes) VALUES (:animalid, :rangerid, :locationid, :sighting_date, :notes);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("animalid", this.animalid)
        .addParameter("rangerid", this.rangerid)
        .addParameter("locationid", this.locationid)
        .addParameter("sighting_date", this.sighting_date)
        .addParameter("notes", this.notes)
        .executeUpdate()
        .getKey();
  }


  public int getId(){
    return this.id;
  }

  public int getAnimalId(){
    return this.animalid;
  }

  public int getRangerId(){
    return this.rangerid;
  }

  public int getLocationId(){
    return this.locationid;
  }

  public String getSighting_date(){
    return new SimpleDateFormat("MMMM dd, yyyy").format(this.sighting_date);
  }

  public String getNotes(){
    return this.notes;
  }

  public String getRangerName(){
    Ranger ranger = Ranger.find(this.rangerid);
    return ranger.getName();
  }

  public String getAnimalSpecies(){
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
  public boolean equals(Object otherSighting){
    if(!(otherSighting instanceof AnimalSighting)){
      return false;
    }else{
      Sighting newSighting = (Sighting) otherSighting;
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
