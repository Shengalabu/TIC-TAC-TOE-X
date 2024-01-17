package source.classes.game;

import source.classes.base_classes.Map;
import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.ClearConsoleObject;


import java.util.Scanner;



public class TicTacToeX_TitleScreen extends Map{
    //constructor
    public TicTacToeX_TitleScreen(Actor owner, AObject worldReference) {
        super(owner, worldReference);
    }

    //Fucntions -----------------------------------------------------------------------
        public void clearThenPrintTextWithDelay(String text, int delayInMilliseconds){
            ClearConsoleObject.clearConsole();
            System.out.println(text);
            delayTime(300);
        }
    
    
        public void executePlayerInput(){
            Scanner myScanner = new Scanner(System.in);
            String userInput = myScanner.nextLine().toLowerCase();

            switch (userInput) {
                case "play":
                    AObject defaultMapInstance = new TicTacToeX_DefaultMap(this, null);
                    myScanner.close();
                    break;
                case "refresh rate":
                    System.out.println("You Got Bamboozled");
                    delayTime(1000);
                    beginPlay();    
                    break;
                case "refreshrate":
                    System.out.println("You Got Bamboozled 2");
                    delayTime(1000);
                    beginPlay();                    
                case "exit":
                    clearThenPrintTextWithDelay("Cleaning.", 200);
                    clearThenPrintTextWithDelay("Cleaning. .", 400);
                    clearThenPrintTextWithDelay("Cleaning. . .", 300);
                    clearThenPrintTextWithDelay("Cleaning Complete!", 100);
                    clearThenPrintTextWithDelay("Exiting Program .", 50);
                    clearThenPrintTextWithDelay("Exiting Program . .", 50);
                    ClearConsoleObject.clearConsole();
                    break;
                    default:
                    System.out.println("------------------ INVALID INPUT ------------------");
                    delayTime(1000);
                    beginPlay();                
                    break;
            }
            myScanner.close();
        }    
    
    
    public static void createTitleScreenDisplay(){
            System.out.println( "|-----------------------------------------------------------------------------------------------------------------------|\n"+
                                "|                                                        WELOCME TO                                                     |\n"+
                                "|                                                      TIC-TAC-TOE-X                                                    |\n"+
                                "|                                                           1.0                                                         |\n"+
                                "|                                                                                                                       |\n"+
                                "|                                                          PLAY                                                         |\n"+
                                "|                                                       REFRESH RATE                                                    |\n"+
                                "|                                                          EXIT                                                         |\n"+
                                "|                                                                                                                       |\n"+
                                "|    Instructions:                                                                                                      |\n"+
                                "|                 - Type the board coordinates to input a move  i.e 11, 23, 21, 33.                                     |\n"+
                                "|                 - 0 HP means Death.                                                                                   |\n"+
                                "|                 - The refresh rate of the game is the only time you can input a move ie. within 1 sec.                |\n"+
                                "|                 - Use your abilities by typing Q,W,E,R (Each have a cooldown)                                         |\n"+
                                "|                 - Earn Toe Essence by killing enemies.                                                                |\n"+
                                "|                 - Type x to stop when in game (not here).                                                             |\n"+
                                "|-----------------------------------------------------------------------------------------------------------------------|");
            System.out.println("Enter Input: ");
                            }
        
        
    
    

    //Overide Begin Play --------------------------------------------------------------
        @Override
        public void beginPlay() {
            super.beginPlay();
            ClearConsoleObject.clearConsole();
            createTitleScreenDisplay();
            executePlayerInput();

        }
}    
