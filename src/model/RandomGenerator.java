package model;

public class RandomGenerator {

    private int upperL;
    private int lowerL;
    
    public RandomGenerator(int l, int u){
        upperL = u;
        lowerL = l;
    }

    public String generateInt(){
        return "" + (int) Math.floor(Math.random()*(upperL - lowerL + 1) + lowerL);
    }

    public String generateChar(){
        return "" + (char)((int) Math.floor(Math.random()*(upperL - lowerL + 1) + lowerL));
    }

}
