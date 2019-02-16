import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Animals{
    public String name;
    public int id;
    public String rangerName;
    public String type;
    public String age;
    public Timestamp citingTime;
    
    public String getName(){
      return name;
    }
    public int getId(){
    return id;
    }
    public String getRangerName(){
        return rangerName;
    }
    public String getType(){
        return type;
    }
    public String getAge(){
        return age;
    }
    public Timestamp getCitingTime(){
      return citingTime;
    }

    @Override
    public boolean equals(Object otherAnimals){
      if (!(otherAnimals instanceof Animals)) {
        return false;
      } else {
        Animals newAnimals = (Animals) otherAnimals;
        return this.getName().equals(newAnimals.getName()) &&
               this.getRangerName().equals(newAnimals.getRangerName())&&
               this.getType().equals(newAnimals.getType())&&
               this.getAge().equals(newAnimals.getAge());
        // return true;
      }
    }
  
    public void save() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO Animals (name, rangerName, type, age) VALUES (:name, :rangerName, :type, :age)";
        this.id = (int) con.createQuery(sql, true)
          .addParameter("name", this.name)
          .addParameter("rangerName", this.rangerName)
          .addParameter("type", this.type)
          .addParameter("age", this.age)
          .executeUpdate()
          .getKey();
      }
    }
    

}