package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.PlayerController;

import java.util.Scanner;

public class TicTacToeXPlayerController extends PlayerController{
    char TicTacToeValue = 'X';
    TicTacToeX_DefaultMap tttx_DefaultMap;
    PlayerPawn player;
    boolean bTakeUserInput = true;
    Scanner myScanner;
    boolean markedForClosing = false;

    //Constructor
    public TicTacToeXPlayerController(Actor owner, AObject worldReference, char TicTacToeValue, PlayerPawn player) {
        super(owner, worldReference);
        this.TicTacToeValue = TicTacToeValue;
        if (worldReference instanceof TicTacToeX_DefaultMap) {
            tttx_DefaultMap = (TicTacToeX_DefaultMap) worldReference;
        }
        this.player = player;
    }

    public void placeCharOnBoard(int index){
        tttx_DefaultMap.setBoardValue(index, TicTacToeValue);
    }

    public void useAbility(int index){
        switch (index) {
            case 0: player.abilityQ.tryRunAbility(); break;
            case 1: player.abilityW.tryRunAbility(); break;
            case 2: player.abilityE.tryRunAbility(); break;
            case 3: player.abilityR.tryRunAbility(); break;
            default:
                break;
        }
    }

    public void takeUserInput(){
            myScanner = new Scanner(System.in);
                while (bTakeUserInput) {
                    if(markedForClosing || tttx_DefaultMap.gameEnded){
                        break;
                    }
                    String userInput = myScanner.nextLine().toLowerCase();
                    switch (userInput) {
                        case "11": placeCharOnBoard(0); break;   
                        case "12": placeCharOnBoard(3); break; 
                        case "13": placeCharOnBoard(6); break; 
                        case "21": placeCharOnBoard(1); break; 
                        case "22": placeCharOnBoard(4); break; 
                        case "23": placeCharOnBoard(7); break; 
                        case "31": placeCharOnBoard(2); break; 
                        case "32": placeCharOnBoard(5); break; 
                        case "33": placeCharOnBoard(8); break; 
                        case "q": useAbility(0); break; 
                        case "w": useAbility(1); break; 
                        case "e": useAbility(2); break; 
                        case "r": useAbility(3); break; 
                        case "x":
                                close();
                                if (worldReference instanceof TicTacToeX_DefaultMap){
                                    ((TicTacToeX_DefaultMap) worldReference).setGameOver(false, true);
                                }
                            break;
                        default:
                        System.out.println("------------------ INVALID INPUT ------------------");
                        break;
                    }
                    if (userInput.equalsIgnoreCase("x")){
                        break;
                    }
                } 
    }


    public void close(){
        bTakeUserInput = false;
        markedForClosing = true;
    }
}


