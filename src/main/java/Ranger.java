import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Ranger implements DatabaseManagement{
    private String name;
    private int id;
    
    public Ranger(String name) {
        this.name = name;
    }
    
      public String getName() {
        return name;
      }
      public int getId() {
        return id;
      }
   
      @Override
      public boolean equals(Object otherRanger){
        if (!(otherRanger instanceof Ranger)) {
          return false;
        } else {
            Ranger newRanger = (Ranger) otherRanger;
          return this.getName().equals(newRanger.getName());
        }
      }

      @Override
      public void save() {
        try(Connection con = DB.sql2o.open()) {
          String sql = "INSERT INTO ranger (name) VALUES (:name)";
          this.id = (int) con.createQuery(sql, true)
            .addParameter("name", this.name)
            .executeUpdate()
            .getKey();
        }
      }
      
      public static List<Ranger> all() {
        String sql = "SELECT * FROM ranger";
        try(Connection con = DB.sql2o.open()) {
         return con.createQuery(sql).executeAndFetch(Ranger.class);
        }
      }

      public static Ranger find(int id) {
        try(Connection con = DB.sql2o.open()) {
          String sql = "SELECT * FROM ranger where id=:id";
          Ranger ranger = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Ranger.class);
          return ranger;
        }
      }

  }