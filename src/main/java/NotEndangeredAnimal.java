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



}