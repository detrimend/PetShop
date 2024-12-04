public class Mammal {
    private boolean outDoorOnly;

    public Mammal outDoorOnly() {
        this.outDoorOnly = outDoorOnly;
    }

    public boolean isOutDoorOnly(){
        return outDoorOnly;
    }

    public String toString(){
        return "[Out door only = " + outDoorOnly + "]";
    }
    public String getType(){
        return "Type of Mammal:";
    }
}
