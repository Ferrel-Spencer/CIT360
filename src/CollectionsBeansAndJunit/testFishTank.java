package CollectionsBeansAndJunit;
//Importing all needed utilities

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by ferre on 5/5/2017.
 */
public class testFishTank {
    fishTank testfishTank; //creating instance of CollectionsBeansAndJunit.fishTank named testfishTank
    fishBean finny,glib, glub, speed, ropey; // creating instances of FishBean named repectivly



    @Before
    public void setup() throws Exception{
        testfishTank = new fishTank(); //initializing CollectionsBeansAndJunit.testFishTank
        testfishTank.fishList.clear();

        finny = new fishBean("Spotted Catfish","Finny","Green with black spots","1"); //initilizing the FishBean with the required fields
        glib = new fishBean("Electric yellow cichlid","Glib","Yellow","2");
        glub = new fishBean("Electric yellow cichlid","Glub","Yellow","2");
        speed = new fishBean("Unknown","Speed","Silver with orange stripes","3");
        ropey = new fishBean("African Ropefish","Ropey","Greenish brown","5");
    }

    @Test
    // hashmap test
    public void testAddFish(){
        testfishTank.addFishToTank(finny);//testing to see if finny is added to the hashmap
        int numFish = testfishTank.fishTank.size(); //checking the number of entries in the hashmap
        assertEquals(1, numFish); //testing to see if there is a fish in the tank

        testfishTank.addFishToTank(glib);
        testfishTank.addFishToTank(glub);
        testfishTank.addFishToTank(speed);
        testfishTank.addFishToTank(ropey);
        numFish = testfishTank.fishTank.size(); //testing to see if there are 5 fish in the tank
        assertEquals(5,numFish);

        testfishTank.fishTank.clear();//clear the hashmap of entries

    }

    @Test
    //hashmap test
    public void testGetFish(){
        testfishTank.fishTank.put("Finny", finny); //placing finny into hashmap by giving <"Finny" (key) , finny(FishBean)> .addfish() does this automatically
        testfishTank.fishTank.put("Glib", glib);

        fishBean finnyFromMap = testfishTank.getFish("Finny"); //testing get fish by searching for key "Finny"
        Assert.assertEquals(finny,finnyFromMap); //Testing to see if finny from map (the test) is the same as finny the FishBean object in the hashmap
        fishBean glibFromMap = testfishTank.getFish("Glib");
        Assert.assertEquals(glib,glibFromMap);

        fishBean notaFish = testfishTank.getFish("Spot the dog"); //testing to see if a non fish can be pulled in the hashmap
        assertNull(notaFish);//testing to see if the non fish is in the hashmap

        testfishTank.fishTank.clear();//clearing hashmap of entries



    }

    @Test
    //Treemap test add fish
    public void testAddFishToDirectory(){
        testfishTank.fishDirectory.put("Finny",finny.getTankNumber());

        int Tanknumber = testfishTank.fishDirectory.size();
        assertEquals(1, Tanknumber);

        testfishTank.fishDirectory.put("Speed",speed.getTankNumber());
        Tanknumber = testfishTank.fishDirectory.size();
        assertEquals(2, Tanknumber);

        testfishTank.fishDirectory.clear();
    }

    @Test
    //Treemap test get fish
    public void testGetFishFromDirectory(){
        testfishTank.fishDirectory.put("Finny",finny.getTankNumber());
        testfishTank.fishDirectory.put("Speed",speed.getTankNumber());

        String finnyNumber = testfishTank.getFishTankNumber("Finny");
        assertEquals("1",finnyNumber);

        String speedNumber = testfishTank.getFishTankNumber("Speed");
        assertEquals("3",speedNumber);

        String nullNumber = testfishTank.getFishTankNumber("null");
        assertNull(nullNumber);

        String noNumber = testfishTank.getFishTankNumber("NoFish");
        assertNull(noNumber);
        testfishTank.fishDirectory.clear();
    }

    @Test
    //Treemap test getAll
    public void testGetFishDirectory(){
        testfishTank.fishDirectory.put("Finny",finny.getTankNumber());
        testfishTank.fishDirectory.put("Speed",speed.getTankNumber());

        String fishDirectory = testfishTank.getFishDirectory();
        String expected = "Finny - 1; Speed - 3; ";
        assertEquals(expected, fishDirectory);
        testfishTank.fishDirectory.clear();
    }

    @Test
    //Arraylist test add
    public void testFishlist(){
        testfishTank.fishList.clear();
        testfishTank.addFishToArraylist(finny);
        testfishTank.addFishToArraylist(speed);
        testfishTank.addFishToArraylist(glib);

        String fishlist = testfishTank.getArrayList();
        String expected = "[Spotted Catfish, Unknown, Electric yellow cichlid]";
        assertEquals(expected,fishlist);



    }


}