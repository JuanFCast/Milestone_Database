package model;

public class RandomGenerator {

    private int upperL;
    private int lowerL;
    
    public RandomGenerator(int l, int u){
        upperL = u;
        lowerL = l;
    }

    public Integer generateInt(){
        return (int) Math.floor(Math.random()*(upperL - lowerL + 1) + lowerL);
    }

    public Character generateChar(){
        int c = (int) Math.floor(Math.random()*(90 - 65 + 1) + 65);
        return (char) c; 
    }

}
