import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class EndangeredAnimalTest{
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void EndangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void EndangeredAnimal_instantiatesWithName_String() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        assertEquals("dun", testEndangeredAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameRangerNameTypeAgeAndLocationAreSame_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        EndangeredAnimal testEndangeredAnimal2 = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      assertTrue(testEndangeredAnimal.equals(testEndangeredAnimal2));
    }

    @Test
    public void save_successfullyAddsEndangeredAnimalToDatabase_List() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        testEndangeredAnimal.save();
        assertTrue(testEndangeredAnimal.equals(EndangeredAnimal.all().get(0)));
    }
    
    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
      EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      firstEndangeredAnimal.save();
      EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      secondEndangeredAnimal.save();
      assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
      assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }

    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
      EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      firstEndangeredAnimal.save();
      EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("dunnn", "dunRanger", "young", "NE Quadrant", "healthy");
      secondEndangeredAnimal.save();
      assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }

}