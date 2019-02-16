import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class NotEndangeredAnimalTest{
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void NotEndangeredAnimal_instantiatesCorrectly_true() {
        NotEndangeredAnimal testNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        assertEquals(true, testNotEndangeredAnimal instanceof NotEndangeredAnimal);
    }

    @Test
    public void NotEndangeredAnimal_instantiatesWithName_String() {
        NotEndangeredAnimal testNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        assertEquals("dun", testNotEndangeredAnimal.getName());
    }


}