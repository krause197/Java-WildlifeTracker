import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Ranger {
  private int id;
  private String name;
  private int roster_number;

  public Ranger(String name, int roster_number){
    if (name.equals("") || roster_number < 0001){
      throw new IllegalArgumentException("Value required for ranger name or roster number");
    }
    this.name = name;
    this.roster_number = roster_number;

    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO rangers (name, roster_number) VALUES (:name, :roster_number);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", name)
        .addParameter("roster_number", roster_number)
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

  public int getRoster_Number(){
    return this.roster_number;
  }


  @Override
  public boolean equals(Object otherObject){
    if(!(otherObject instanceof Ranger)){
      return false;
    }else{
      Ranger newRanger = (Ranger) otherObject;
      return newRanger.getId() == this.id;
    }
  }

  public Ranger find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM rangers WHERE id=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetchFirst(Ranger.class);
    }
  }

  public static List<Ranger> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM rangers";
      return con.createQuery(sql).executeAndFetch(Ranger.class);
    }
  }

  public void update(){
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE rangers SET (name=:name, roster_number=:roster_number) WHERE id=:id";
      con.createQuery(sql)
        .addParameter("name", this.name)
        .addParameter("roster_number", this.roster_number)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public void delete(){
    try(Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM rangers WHERE id=:id";
      con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public List<Sighting> allSightings(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE rangerid=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Sighting.class);
    }
  }
}
