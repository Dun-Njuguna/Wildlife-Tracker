import java.sql.Timestamp;
import org.sql2o.*;
import java.util.List;

public class NotEndangeredAnimal extends Animals implements DatabaseManagement {

    private String location;
    private String health;
    public Timestamp citingTime;

    public static final String ANIMAL_TYPE = "NotEndangeredAnimal";

    public NotEndangeredAnimal(String name, String rangerName, String age, String location, String health){
        this.name = name;
        this.rangerName = rangerName;
        this.type = ANIMAL_TYPE;
        this.age = age;
        this.location = location;
        this.health = health;
    }
    
    public String getLocation(){
        return location;
      }

    public String getHealth(){
      return health;
    }

    @Override
    public void save() {
      try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, rangerName, type, age, location, health) VALUES (:name, :rangerName, :type, :age, :location, :health)";
          this.id = (int) con.createQuery(sql, true)
          .addParameter("name", this.name)
          .addParameter("rangerName", this.rangerName)
          .addParameter("type", this.type)
          .addParameter("age", this.age)
          .addParameter("location", this.location)
          .addParameter("health", this.health)
          .executeUpdate()
          .getKey();
      }
    }



}