package Algorithmen;
import java.util.Currency;
import java.util.Random;

import main.main;

public class DiveAlgorithmus implements DiveAlg{

    private int xPos;
    private int yPos;
    private int likelihood;

    int newXpos;
    int newYpos;

    private  ArrayHandler  arrayHandler = main.getArray();
    private FishAlg fish;

    public DiveAlgorithmus(int pLikelihood, FishAlg pFish){
        this.likelihood = pLikelihood;
        this.fish = pFish;
    }

    @Override
    public void changePos() {

        newXpos = xPos;
        newYpos = yPos;

       /* System.out.println("xPos: "+xPos);
        System.out.println("yPos: "+yPos);*/

        changeXpos();

        if(isHighChange())
            changeYpos();

        /*System.out.println("newXpos: "+newXpos);
        System.out.println("newpos: "+newYpos);*/

        move();
    }

    private void changeXpos() {

        if(xPos==0){
            newXpos++;
            fish.setFishLookRight();
        }else
        if(xPos==arrayHandler.getRowLength()-1){
            newXpos--;
            fish.setFishLookLeft();
        }else{ 
            int randMove = randMoveNum();
            newXpos += randMove;

            if(randMove < 0)
                fish.setFishLookLeft();

            if(randMove > 0)
                fish.setFishLookRight();
        }
    }

    private void changeYpos() {

        if(yPos==0){
            newYpos++;
        }else 
        if(yPos==arrayHandler.getColumnLength()-1){
            newYpos--;
        }else{
            newYpos += randMoveNum();
        }
    }


    void move(){
        //FishAlg fish = arrayHandler.getCell(xPos, yPos);
        FishAlg fishNewPos = arrayHandler.getCell(newXpos, newYpos);

        if(fish == fishNewPos)
            return;

        if(fishNewPos != null){
            eat(fish, fishNewPos);
            return;
        }

        if(fishNewPos == null){
            /*System.out.println("xposBreak: "+xPos);
            System.out.println("yposBreak: "+yPos);*/

            arrayHandler.addNewFish(newXpos, newYpos, fish);
            arrayHandler.clearCell(xPos, yPos);
            xPos = newXpos;
            yPos = newYpos;

            //System.out.println("moved: "+ fish);
            return;

        }

    }


    private void eat(FishAlg currentFish, FishAlg fishNewPos) {

        /*System.out.println("eat1: "+currentFish);
        System.out.println("eat2: "+fishNewPos);*/

        if(currentFish.getSize() >= fishNewPos.getSize()){
            arrayHandler.addNewFish(newXpos, newYpos, currentFish);
            arrayHandler.clearCell(xPos, yPos);
            xPos = newXpos;
            yPos = newYpos;
        }

        if(currentFish.getSize() < fishNewPos.getSize()){
            arrayHandler.clearCell(xPos, yPos);
        }

        //System.out.println("eat");
    }

    private int randMoveNum(){
        Random rand = new Random();
        //return rand.nextInt((1 - -1) + 1) + -1;
        int randomMoveDir = rand.nextInt(1000);
        return (randomMoveDir % likelihood == 0)? -1 : 1;
    }


    private boolean isHighChange() {
        Random rand = new Random();
        
        if(rand.nextInt(likelihood)==0)
            return true;

        return false;
    }



    //getter-setter

    @Override
    public void setNewPos(int pXpos, int pYpos) {
        this.xPos = pXpos;
        this.yPos = pYpos;
    }

    @Override
    public int getXpos() {
        return xPos;
    }

    @Override
    public int getYpos() {
       return yPos;
    }
}
