package Algorithmen;
public interface FishAlg {
    public void changePos();
    public void setNewPos(int xPos, int yPos);
    public int getXpos();
    public int getYpos();
    public int getSize();
    public String getFishLook();
    public void setFishLookLeft();
    public void setFishLookRight();
}