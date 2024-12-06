package model;

public class Mammal extends AnimalInfo {
    private boolean outdoorOnly;

    public Mammal (char gender, int age, String species, boolean outdoorOnly) {
        super(gender, age, species);
        this.outdoorOnly = outdoorOnly;
    }

    public boolean isOutDoorOnly(){
        return outdoorOnly;
    }

    @Override
    public String toString(){
        return "Mammal - " + super.toString() + ", Only outdoors " + outdoorOnly;
    }

    @Override
    public String getType(){
        return "Mammal";
    }
}
