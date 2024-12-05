package model;

public class Mammal extends AnimalInfo {
    private boolean outDoorOnly;

    public Mammal (char gender, int age, String species, boolean outDoorOnly) {
        super(gender, age, species);
        this.outDoorOnly = outDoorOnly;
    }

    public boolean isOutDoorOnly(){
        return outDoorOnly;
    }

    @Override
    public String toString(){
        return "Mammal - " + super.toString() + ", Only outdoors " + outDoorOnly;
    }

    @Override
    public String getType(){
        return "Mammal";
    }
}
