package source.classes.game;

import source.classes.base_classes.Map;
import source.classes.base_classes.math.Vectors;
import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.ClearConsoleObject;

import java.util.Timer;
import java.util.TimerTask;

import java.util.Scanner;



public class TicTacToeX_DefaultMap extends Map{
    //constructor --------------------------------------------------------------
    PlayerPawn playerX;
    PlayerPawn playerO;
    int ticks = 0;


    public TicTacToeX_DefaultMap(Vectors.Vector3D actorVectors, Actor owner, AObject worldReference) {
        super(actorVectors, owner, worldReference);

    }

    //functions --------------------------------------------------------------
        //Set Player Index and reference for the game to know who is X and O.
        public void SetAsPlayerIndex(int index, PlayerPawn playerPawn){
            switch (index) {
                case 0:
                    this.playerX = playerPawn;
                    break;
                case 1:
                    this.playerO = playerPawn;
                    break;
                default:
                    this.playerX = playerPawn;
                    break;
            } 
        }

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
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------|\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "                                                      1   2   3  \n"+
                                "                                                    |-----------|\n"+
                                "                                                 1  | X | O | X |\n"+
                                "                                                 2  | X | O | X |\n"+
                                "                                                 3  | X | O | X |\n"+
                                "                                                    |-----------|\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                               "|-----------------------------------------------------------------------------------------------------------------------|");

        }

        public PlayerPawn getActivePlayerIndex(){
            return playerX;
        }

        public void refreshDisplay(){
            ClearConsoleObject.clearConsole();
            createDisplay();
             if (playerX.owner instanceof TicTacToeXPlayerController){
                TicTacToeXPlayerController tttxPlayerController = (TicTacToeXPlayerController) playerX.owner;
                tttxPlayerController.takeUserInput();
            }
        }

        public void tick(){
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    refreshDisplay();
                }
            }, 0, 1000);

        }
    //Overide Begin Play --------------------------------------------------------------
    @Override
    public void beginPlay() {
        super.beginPlay();
        AObject GameInstance = new TicTacToeXGameInstance(new Vectors.Vector3D (0.0,0.0,0.0), this, this);
        tick();
    }
}
    
