package source.classes.game;

import java.util.Scanner;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.PlayerController;
import source.classes.base_classes.math.Vectors;

public class TicTacToeXPlayerController extends PlayerController{
    
    TicTacToeX_DefaultMap ticTacToeX_DefaultMap;
    int boardIndex = 0;

    //constructor
    public TicTacToeXPlayerController(Vectors.Vector3D actorVectors, Actor owner, source.classes.base_classes.AObject worldReference) {
        super(actorVectors, owner, worldReference);
    }




    //Fucntions   
        public void takeUserInput(){
            Scanner myScanner = new Scanner(System.in);
                while (myScanner.hasNextLine()) {
                    String userInput = myScanner.nextLine().toLowerCase();
                    switch (userInput) {
                        case "11": boardIndex = 0; break;   
                        case "12": boardIndex = 3; break; 
                        case "13": boardIndex = 6; break; 
                        case "21": boardIndex = 1; break; 
                        case "22": boardIndex = 4; break; 
                        case "23": boardIndex = 7; break; 
                        case "31": boardIndex = 2; break; 
                        case "32": boardIndex = 5; break; 
                        case "33": boardIndex = 8; break; 
                        case "x":
                            AObject titleScreen = new TicTacToeX_TitleScreen(new Vectors.Vector3D(0.0, 0.0, 0.0), null, null);
                            this.ticTacToeX_DefaultMap.stopTick();
                            myScanner.close();
                            break;
                        default:
                        System.out.println("------------------ INVALID INPUT ------------------");
                        break;
                    }
                    setBoardValue();
                }
        }
        
        public void setBoardValue(){
            ticTacToeX_DefaultMap.setBoardValue(this.boardIndex, true);
        }

        public TicTacToeX_DefaultMap setDefaultMapRef(){
            if (worldReference instanceof TicTacToeX_DefaultMap){
                this.ticTacToeX_DefaultMap = (TicTacToeX_DefaultMap) worldReference;
                return ticTacToeX_DefaultMap;
            }
            return ticTacToeX_DefaultMap;

        }


    @Override
    public void beginPlay() {
        super.beginPlay();
        setDefaultMapRef();
        AObject playerRef = new PlayerPawn(new Vectors.Vector3D (1000.0,0.0,0.0), this, worldReference);
        
    }
}