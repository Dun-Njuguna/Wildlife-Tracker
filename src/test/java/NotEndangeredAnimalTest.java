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

    @Test
    public void equals_returnsTrueIfNameRangerNameTypeAgeAndLocationAreSame_true() {
        NotEndangeredAnimal testNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        NotEndangeredAnimal testNotEndangeredAnimal2 = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      assertTrue(testNotEndangeredAnimal.equals(testNotEndangeredAnimal2));
    }

    @Test
    public void save_successfullyAddsNotEndangeredAnimalToDatabase_List() {
        NotEndangeredAnimal testNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        testNotEndangeredAnimal.save();
        assertTrue(testNotEndangeredAnimal.equals(NotEndangeredAnimal.all().get(0)));
    }
    
    @Test
    public void save_assignsIdToNotEndangeredAnimal() {
        NotEndangeredAnimal testNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
        testNotEndangeredAnimal.save();
        NotEndangeredAnimal savedNotEndangeredAnimal = NotEndangeredAnimal.all().get(0);
        assertEquals(savedNotEndangeredAnimal.getId(), testNotEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfNotEndangeredAnimal_true() {
      NotEndangeredAnimal firstNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      firstNotEndangeredAnimal.save();
      NotEndangeredAnimal secondNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      secondNotEndangeredAnimal.save();
      assertEquals(true, NotEndangeredAnimal.all().get(0).equals(firstNotEndangeredAnimal));
      assertEquals(true, NotEndangeredAnimal.all().get(1).equals(secondNotEndangeredAnimal));
    }

    @Test
    public void find_returnsNotEndangeredAnimalWithSameId_secondNotEndangeredAnimal() {
      NotEndangeredAnimal firstNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      firstNotEndangeredAnimal.save();
      NotEndangeredAnimal secondNotEndangeredAnimal = new NotEndangeredAnimal("dunnn", "dunRanger", "young", "NE Quadrant", "healthy");
      secondNotEndangeredAnimal.save();
      assertEquals(NotEndangeredAnimal.find(secondNotEndangeredAnimal.getId()), secondNotEndangeredAnimal);
    }

    @Test
    public void save_recordsTimeOfCreationInDatabase() {
      NotEndangeredAnimal firstNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      firstNotEndangeredAnimal.save();
      Timestamp savedNotEndangeredAnimalCitingtime = EndangeredAnimal.find(firstNotEndangeredAnimal.getId()).getCitingTime();
      Timestamp rightNow = new Timestamp(new Date().getTime());
      assertEquals(rightNow.getDay(), savedNotEndangeredAnimalCitingtime.getDay());
    }

    @Test
    public void delete_deletesEndangeredAnimal_true() {
      NotEndangeredAnimal firstNotEndangeredAnimal = new NotEndangeredAnimal("dun", "dunRanger", "young", "NE Quadrant", "healthy");
      firstNotEndangeredAnimal.save();
      firstNotEndangeredAnimal.delete();
      assertEquals(null, EndangeredAnimal.find(firstNotEndangeredAnimal.getId()));
    }

}