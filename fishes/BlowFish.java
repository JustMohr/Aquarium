package fishes;

import Algorithmen.*;

public class BlowFish implements FishAlg{

    int fishSize = 5;
    String fishLook = "   <()><  ";
    DiveAlg diveAlg = new DiveAlgorithmus(10, this);

    @Override
    public void changePos() {
        diveAlg.changePos();
    }

    @Override
    public void setNewPos(int xPos, int yPos){
        diveAlg.setNewPos(xPos, yPos);
    }

    @Override
    public int getXpos() {
        return diveAlg.getXpos();
    }

    @Override
    public int getYpos() {
        return diveAlg.getYpos();
    }

    @Override
    public int getSize() {
        return fishSize;
    }

    @Override
    public String getFishLook() {
        return fishLook;
    }

    @Override
    public void setFishLookLeft() {
        fishLook = "<()><";
    }

    @Override
    public void setFishLookRight() {
        fishLook = "><()>";
    }
    
}
