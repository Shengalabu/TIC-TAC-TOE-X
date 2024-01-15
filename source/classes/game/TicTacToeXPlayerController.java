package source.classes.game;

import java.util.Scanner;

import source.classes.base_classes.AMap;
import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.PlayerController;
import source.classes.base_classes.math.Vectors;

public class TicTacToeXPlayerController extends PlayerController{
    
    TicTacToeX_DefaultMap ticTacToeX_DefaultMap;
    int boardIndex = 0;
    int abilityUseIndex = 0;
    Board board;

    //constructor
    public TicTacToeXPlayerController(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
        super(actorVectors, owner, worldReference);
    }

    //Fucntions   
        //takes input from the player 
        public void takeUserInput(){
            boolean placedOnBoardNotAbility = true;

            Scanner myScanner = new Scanner(System.in);
                while (myScanner.hasNextLine()) {
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
                        case "Q": useAbility(1); break; 
                        case "W": useAbility(2); break; 
                        case "E": useAbility(3); break; 
                        case "R": useAbility(4); break; 
                        case "x":
                            this.board.stopTick();
                            new TicTacToeX_TitleScreen(new Vectors.Vector3D(0.0, 0.0, 0.0), null, null);
                            break;
                        default:
                        System.out.println("------------------ INVALID INPUT ------------------");
                        break;
                    }
                } 
        }
        
        public void setBoardValue(){
            this.board.setBoardValue(this.boardIndex, true);
        }

        public void setNewBoardValue(Board board){
            this.board = board;
        }

        public void placeCharOnBoard(int index){
            this.boardIndex = index;
            setBoardValue();
        }

        public void useAbility(int index){
            this.abilityUseIndex = index;
            
        }
    @Override
    public void beginPlay() {
        super.beginPlay();
        AObject playerRef = new PlayerPawn(new Vectors.Vector3D (1000.0,0.0,0.0), this, worldReference);
        
    }
}