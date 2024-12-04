public class Fish {
    private boolean saltWater;

    public Fish saltWater() {
        this.saltWater = saltWater;
    }

    public boolean isSaltWater(){
        return saltWater;
    }

    public String toString(){
        return "[Is salt water = " + saltWater + "]";
    }
    public String getType(){
        return "Type of fish:";
    }


}
