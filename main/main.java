package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Algorithmen.ArrayHandler;
import Algorithmen.FishAlg;
import fishes.*;

public class main{

    static ArrayHandler arrayHandler = new ArrayHandler();

    static int height = 0;
    static int width = 0;

    public static void main(String[]args){
        
        inputHeight();
        inputWidth();
        fillArr();        

        while(true){

            try {
                Thread.sleep(2000);
                callMove();
                //arrayHandler.iterate();
                draw();
            } catch (InterruptedException e) {}

            

        }

    }


    private static void draw() {

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println();
        System.out.println();

        for(int i = 0; i<width; i++)
            System.out.print("----------");
        System.out.println();

        for(int c=0; c<arrayHandler.getColumnLength(); c++){
            for(int r = 0; r<arrayHandler.getRowLength(); r++){
               
                FishAlg selectedFish = arrayHandler.getCell(r, c);
                if(selectedFish == null){
                    System.out.print("          ");
                    continue;
                }

                System.out.print(selectedFish.getFishLook()+"");              
            }
            System.out.println();
        }
        for(int i = 0; i<width; i++)
            System.out.print("----------");
        System.out.println();
    }


    private static void callMove() {

        ArrayList<FishAlg> allreadyMoved = new ArrayList<>();

        System.out.println();
        for(int c=0; c<arrayHandler.getColumnLength(); c++){
            for(int r = 0; r<arrayHandler.getRowLength(); r++){
                //System.out.print(arrayHandler.getCell(r, c));
                FishAlg selectedFish = arrayHandler.getCell(r, c);

                if(selectedFish==null || allreadyMoved.contains(selectedFish))
                    continue;
                
                allreadyMoved.add(selectedFish);
                selectedFish.changePos();
                
            }
            //System.out.println();
            allreadyMoved.clear();
        }
    }

    static void fillArr(){//rewrite

        arrayHandler.createArraySize(width, height);
        Random rand = new Random();

        for(int i=0; i<height; i++){
            int fishSelectNum = rand.nextInt(3 + 1);//4= number of fishes
            int randomXpos = rand.nextInt(width);
            int randomYpos = rand.nextInt(height);

            FishAlg fishKind = null;
            switch (fishSelectNum) {
                case 0:
                    fishKind = new Shark();
                    break;
            
                case 1:
                    fishKind = new Carp();
                    break;

                case 2:
                    fishKind = new BlowFish();
                    break;

                case 3:
                    fishKind = new SwordFish();
                    break;
            }

            if(arrayHandler.getCell(randomXpos, randomYpos)!=null){
                i--;
                continue;
            }
            
            fishKind.setNewPos(randomXpos, randomYpos);
            arrayHandler.addNewFish(randomXpos, randomYpos, fishKind);

        }

        
        arrayHandler.iterate();        
            
         
    }

    static void inputHeight(){

        Scanner scanner =new Scanner(System.in);

            try 
            { 
                System.out.println("höhe: ");
                height = scanner.nextInt();
            }  
            catch (Exception e)  
            { 
                System.out.println("Gebe einen gültigen Wert ein");
                inputHeight();
            } 

            if(height<=0){
                System.out.println("Gebe einen gültigen Wert ein");
                inputHeight();
            }
                
    }

    static void inputWidth(){

        Scanner scanner =new Scanner(System.in);

            try 
            { 
                System.out.println("breite: ");
                width = scanner.nextInt();
            }  
            catch (Exception e)  
            { 
                System.out.println("Gebe einen gültigen Wert ein");
                inputWidth();
            }
            if(width<=0){
                System.out.println("Gebe einen gültigen Wert ein");
                inputWidth();
            }
                
    }


    public static ArrayHandler getArray(){
        return arrayHandler;
    }

}