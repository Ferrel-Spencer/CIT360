package CollectionsBeansAndJunit;//importing all of the needed utilities

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;


/**
 * Created by ferre on 5/5/2017. This class implements CollectionsBeansAndJunit.fishBean and adds in a hashMap containing multiple fish
 */



public class fishTank {
    HashMap <String, fishBean> fishTank; //creating a HashMap and naming it FishTank
    TreeMap <String, String> fishDirectory; //creating a TreeMap that holds the info of where a fish is located
    ArrayList<String> fishList;

    //this is the constructor for the CollectionsBeansAndJunit.fishTank class that initializes the HashMap, TreeMap, and ArrayList
    public fishTank() {
        fishTank = new HashMap<String, fishBean>(); //constructor of class that builds the HashMap
        fishDirectory = new TreeMap<String, String>(); //constructor that builds a TreeMap
        fishList = new ArrayList<String>();

    }

    //this takes a fish and adds it to a tank (hashmap)
    public void addFishToTank(fishBean aFish){ //adds a FishBean to the hashmap
        if (aFish != null && aFish.getName() != null ) { //this section creates a key that can me associated with the FishBean
            String key = aFish.getName();
            fishTank.put(key,aFish); //places the fish into the hashmap
        }
    }

    //this takes a fish and adds it to the TreeMap
    public void addFishToDirectory(fishBean aFish){
        if(aFish != null && aFish.getName() != null){
            String key = aFish.getName();
            fishDirectory.put(key,aFish.getTankNumber());
        }

    }

    //this adds the list of fish species currently
    public void addFishToList(fishBean aFish){
        if(aFish != null && aFish.getSpecies() != null){
            fishList.add(aFish.getSpecies());
        }

    }

    //takes all the fish species and adds them to the arrayList and displays all entries
    public void addFishToArraylist(fishBean afish){
        if (afish != null && afish.getSpecies()!= null){
            String entity = afish.getSpecies();
            fishList.add(entity);
        }
    }

    //this takes the key value of the TreeMap and returns the associated fish's Tank number
    public String getFishTankNumber(String fishName){
        if(fishName == null){
            return null;
        }
        return fishDirectory.get(fishName);
    }

    //this takes the returns the fish's name used later in the keys for both the HashMap and TreeMap
    public fishBean getFish(String name){ //this method gets takes the string name of the Fish bean and returns the FishBean object if found
        return fishTank.get(name);
    }

    //gets all of the fish in the fishDirectory TreeMap
    public String getFishDirectory(){
        StringBuffer tankNumberBuffer = new StringBuffer();
        TreeSet<String> sortedKeys = new TreeSet<String>(fishDirectory.keySet());
        for(String akey : sortedKeys){
            String tankNumber = fishDirectory.get(akey);
            tankNumberBuffer.append(akey);
            tankNumberBuffer.append(" - ");
            tankNumberBuffer.append(tankNumber);
            tankNumberBuffer.append("; ");
        }
        return tankNumberBuffer.toString();
    }

    //this displays the list of species in store
    public String getArrayList(){
        return fishList.toString();
    }


}