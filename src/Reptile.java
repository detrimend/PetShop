public class Reptile {
    private boolean venomous;

    public Reptile venomous() {
        this.venomous = venomous;
    }

    public boolean isVenomous(){
        return venomous;
    }

    public String toString(){
        return "[Is venomous = " + venomous + "]";
    }
    public String getType(){
        return "Type of reptile:";
    }
}
