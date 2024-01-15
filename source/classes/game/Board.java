package source.classes.game;

import source.classes.base_classes.Map;
import source.classes.base_classes.math.Vectors;
import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.ClearConsoleObject;

import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.Track;

import java.util.Scanner;



public class Board extends Actor{
    //constructor --------------------------------------------------------------
    PlayerPawn playerX;
    PlayerPawn playerO;
    int ticks = 0;
    Timer timer;
    char[] boardData;

    public Board(Vectors.Vector3D actorVectors, Actor owner, AObject worldReference) {
        super(actorVectors, owner, worldReference);
    }

    //functions --------------------------------------------------------------
        //Set Player Index and reference for the game to know who is X and O.

        //Refreshes The UI
        public void TickRefreshTheConsole(){
            Scanner myScanner = new Scanner(System.in);
            while(true){
                ClearConsoleObject.clearConsole();
                ticks++;
                System.out.println("WELCOME TO TIC-TAC-TOE-X | ticks: " + ticks);
                String userInput = myScanner.nextLine();
                
                if(userInput.equalsIgnoreCase("exit")){
                    break;
                }

                System.out.println("You Entered: " + userInput);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            myScanner.close();
        }

        public void createDisplay(){
            System.out.println("|----------------------------------------------------- OPPONENT ----------------------------------------------------|\n"+
                                "\n");
                                System.out.printf  ("%-26s%-26s%-26s%-26s%-26s\n", "Cull:" + "15", "Fireball:" + "12", "Cosmic_Rupture:" + "10","Parry:" + "5", "Health: " + "100"); 

            System.out.println ("\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "                                                      1   2   3  \n"+
                                "                                                    |-----------|\n"+
                                "                                                 1  | "+ this.boardData[0] +" | "+ this.boardData[1] +" | "+ this.boardData[2] +" |\n"+
                                "                                                 2  | "+ this.boardData[3] +" | "+ this.boardData[4] +" | "+ this.boardData[5] +" |\n"+
                                "                                                 3  | "+ this.boardData[6] +" | "+ this.boardData[7] +" | "+ this.boardData[8] +" |\n"+
                                "                                                    |-----------|\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n");
     System.out.printf  ("%-26s%-26s%-26s%-26s%-26s\n", "Cull:" + "15", "Fireball:" + "12", "Cosmic_Rupture:" + "10","Parry:" + "5", "Health: " + "100"); 
             System.out.println("\n");
             System.out.println("Status: \n"+
                                "|------------------------------------------------------- YOU -------------------------------------------------------|\n");
            System.out.println("Enter input: ");

            
                            
        }

        public  PlayerPawn getActivePlayer(){
            return playerX;
        }
        
        public  void allowActivePlayerToMakeMove(){
            if (getActivePlayer().owner instanceof TicTacToeXPlayerController){
                    TicTacToeXPlayerController tttxPlayerController = (TicTacToeXPlayerController) getActivePlayer().owner;;
                    tttxPlayerController.takeUserInput();
                }
        }
        
        //For when the player is an X or an O (True on X)
        public char setBoardValueBasedOnBool(Boolean bool){
            if (bool) {
                return 'X';
            }
            return 'O';
        }
     
        public boolean checkIfThreeIndicesAreTheSameChar(int n1, int n2, int n3){
            if ((this.boardData[n1] == this.boardData[n2]) && (this.boardData[n2] == this.boardData[n3]) && (this.boardData[n1] != ' ')) {
                return true;
            }
            return false;
        }

        public boolean checkIfSomeoneHasWonInBoardCombat(){
            if(
                checkIfThreeIndicesAreTheSameChar(0,1,2)
                ||
                checkIfThreeIndicesAreTheSameChar(3,4,5)
                ||
                checkIfThreeIndicesAreTheSameChar(6,7,8)
                ||
                checkIfThreeIndicesAreTheSameChar(0,3,6)
                ||
                checkIfThreeIndicesAreTheSameChar(1,4,7)
                ||
                checkIfThreeIndicesAreTheSameChar(6,7,8)
                ||
                checkIfThreeIndicesAreTheSameChar(0,4,8)
                ||
                checkIfThreeIndicesAreTheSameChar(6,4,2)
            ){
                return true;
            }
            return false;
        }

        public void setBoardValue(int index, boolean isX){
            if(this.boardData[index] == ' '){
                this.boardData[index]= setBoardValueBasedOnBool(isX);
            }
            if (checkIfSomeoneHasWonInBoardCombat()){
                stopTick();
            }
            refreshDisplay();
        }

        public void refreshDisplay(){
            ClearConsoleObject.clearConsole();
            createDisplay();
        }

        public void tick(Timer timer){
            this.timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run(){
                    refreshDisplay();
                }
            }, 0, 1000);
        }
        
        public void stopTick(){
            
            
            this.timer.cancel();
            this.timer.purge();
            ClearConsoleObject.clearConsole();
        }

    //Overide Begin Play --------------------------------------------------------------
    @Override
    public void beginPlay() {
        super.beginPlay();
        boardData = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        tick(this.timer = new Timer());
        allowActivePlayerToMakeMove();
    }
}
    
