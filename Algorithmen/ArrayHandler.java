package Algorithmen;

public class ArrayHandler {

    private FishAlg[][] fishArr;
    

    public void createArraySize(int xSize, int ySize){
        fishArr = new FishAlg[ySize][xSize];
    }

    public void addNewFish(int xPos, int yPos, FishAlg fishKind){
        fishArr[yPos][xPos] = fishKind;
    }


    //getter

    public int getColumnLength(){
        return fishArr.length;
    }

    public int getRowLength(){
        return fishArr[0].length;
    }

    public FishAlg getCell(int xPos, int yPos){
        return fishArr[yPos][xPos];
    }

    public void clearCell(int xPos, int yPos){
        fishArr[yPos][xPos] = null;
    }


    public void iterate(){
        for(int r=0; r<fishArr.length; r++){
            for(int c =0; c<fishArr[r].length; c++){
                System.out.print(fishArr[r][c]+" - ");
            }
            System.out.println();
        }
    }
}
