import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Location implements DatabaseManagement {

  private int id;
  private String name;
  private String mgrs;

  public Location(String name, String mgrs){
    if (name.equals("") || mgrs.equals("")){
      throw new IllegalArgumentException("Input required for Location or Military Grid Reference Coordinate");
    }
    this.name = name;
    this.mgrs = mgrs;

    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO locations (name, mgrs) VALUES (:name, :mgrs);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("mgrs", this.mgrs)
        .executeUpdate()
        .getKey();
  }
}

  public int getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getMgrs(){
    return this.mgrs;
  }

  @Override
  public boolean equals(Object otherObject){
    if(!(otherObject instanceof Location)){
      return false;
    }else{
      Location newLocation = (Location) otherObject;
      return newLocation.getId() == this.id;
    }
  }

  public static Location find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM locations WHERE id=:id";
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Location.class);
    }
  }

  public static Location findMgrs(int id){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT mgrs FROM locations WHERE id=:id;";
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Location.class);
    }
  }

  public static List<Location> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM locations";
      return con.createQuery(sql).executeAndFetch(Location.class);
    }
  }

  public void update(){
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE locations SET (name=:name, mgrs=:mgrs) WHERE id=:id";
      con.createQuery(sql)
        .addParameter("name", this.name)
        .addParameter("mgrs", this.mgrs)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public void delete(){
    try(Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM locations WHERE id=:id";
      con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public List<Sighting> allSightings(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE locationid=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Sighting.class);
    }
  }

}
