public class Bird extends AnimalInfo {
    private boolean tame;
    private boolean isTameable;

    public Bird(char gender, int age, String species, boolean tame, boolean isTameable){
        super(gender, age, species);
    }
    public boolean isTame(){
        return tame;
    }

    public boolean isTameable(){
        return isTameable;
    }
    public String toString(){
        return "Bird " + super.toString() + " tame " + tame;
    }

    public String getType(){
        return "Bird";
    }
}
