public class Reptile extends AnimalInfo {
    private boolean venomous;

    public Reptile (char gender, int age, String species, boolean venomous) {
        super(gender,age,species);
        this.venomous = venomous;
    }

    public boolean isVenomous(){return venomous;}

    @Override
    public String toString(){
        return "Reptile " + super.toString() + venomous;
    }

    @Override
    public String getType(){
        return "Reptile";
    }
}
