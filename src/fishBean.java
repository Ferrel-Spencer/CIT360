import java.io.Serializable;

/**
 * Created by ferre on 5/5/2017.
 */
public class fishBean implements Serializable {

    String color;
    String name;
    String species;
    String tankNumber;

    fishBean() { //empty consructor
    }

    public String getName() { //this takes the name of a FishBean and returns the name associated
        return this.name;
    }

    public String getTankNumber(){ //this takes the tank number of the fishBean and returns the associated tankNumber
        return this.tankNumber;
    }

    public String getSpecies(){
        return this.species;
    }


    fishBean(String species, String name, String color, String tankNumber) { //this is a constructor that sets all of the values at once when called
        this.species = species;
        this.name = name;
        this.color = color;
        this.tankNumber = tankNumber;
    }
}

/**QUESTION ABOUT THE ABOVE LINES:  21-24. Previously I had it set to be species = this.species; however it wouldn't pull the
 value that I needed. Why did changing the order work?
 */
