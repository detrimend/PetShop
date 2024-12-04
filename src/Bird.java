public class Bird {
    private boolean tame;
    private boolean isTameable;

    public boolean isTame(){
        return tame;
    }
    public boolean isTameable(){
        this.isTameable = isTameable;
    }

    public boolean isTame(){
        return tame;
    }

    public boolean isTameable(){
        return isTameable;
    }

    public String toString(){
        return "[tame = " + tame + " Is tameable = " + isTameable + "]";
    }

    public String getType(){
        return "Bird type = ";
    }
}
