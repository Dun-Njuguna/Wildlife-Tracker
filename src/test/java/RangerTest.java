import org.junit.*;
import static org.junit.Assert.*;

public class RangerTest {
  
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Ranger_instantiatesCorrectly_true() {
      Ranger testRanger = new Ranger("DUN");
      assertEquals(true, testRanger instanceof Ranger);
    }
  
    @Test
    public void getName_RangerInstantiatesWithName_Dun() {
      Ranger testRanger = new Ranger("Dun");
      assertEquals("Dun", testRanger.getName());
    }
    @Test
    public void equals_returnsTrueIfNameIsSame_true() {
      Ranger firstRanger = new Ranger("Dun");
      Ranger secondRanger = new Ranger("Dun");
      assertTrue(firstRanger.equals(secondRanger));
    }
  
    @Test
    public void save_insertsObjectIntoDatabase_Ranger() {
      Ranger testRanger = new Ranger("Dun");
      testRanger.save();
      assertTrue(Ranger.all().get(0).equals(testRanger));
    } 

    @Test
    public void all_returnsAllInstancesOfRanger_true() {
      Ranger firstRanger = new Ranger("Dun");
      firstRanger.save();
      Ranger secondRanger = new Ranger("Duncan");
      secondRanger.save();
      assertEquals(true, Ranger.all().get(0).equals(firstRanger));
      assertEquals(true, Ranger.all().get(1).equals(secondRanger));
    }
  
    @Test
    public void save_assignsIdToRanger() {
      Ranger testRanger = new Ranger("Dun");
      testRanger.save();
      Ranger savedRanger = Ranger.all().get(0);
      assertEquals(testRanger.getId(), savedRanger.getId());
    }
  
    @Test
    public void find_returnsRangerWithSameId_secondRanger() {
      Ranger firstRanger = new Ranger("Dun");
      firstRanger.save();
      Ranger secondRanger = new Ranger("Duncan");
      secondRanger.save();
      assertEquals(Ranger.find(secondRanger.getId()), secondRanger);
    }
      
}