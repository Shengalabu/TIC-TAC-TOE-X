package source.classes.game;

import java.util.Scanner;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.PlayerController;
import source.classes.base_classes.math.Vectors;

public class TicTacToeXPlayerController extends PlayerController{
    //constructor
    public TicTacToeXPlayerController(Vectors.Vector3D actorVectors, Actor owner, source.classes.base_classes.AObject worldReference) {
        super(actorVectors, owner, worldReference);
    }
    //Fucntions   
        public void takeUserInput(){
            System.out.println("Enter input: ");
            Scanner myScanner = new Scanner(System.in);
                while (myScanner.hasNextLine()) {
                    String userInput = myScanner.nextLine().toLowerCase();
                    switch (userInput) {
                        case "11":

                            break;
                        case "x":
                            if (worldReference instanceof TicTacToeX_DefaultMap){
                                TicTacToeX_DefaultMap tttxDefaultMap = (TicTacToeX_DefaultMap) worldReference;
                                tttxDefaultMap.stopTick();
                            }
                            AObject titleScreen = new TicTacToeX_TitleScreen(new Vectors.Vector3D(0.0, 0.0, 0.0), null, null);
                            break;
                        default:
                        System.out.println("------------------ INVALID INPUT ------------------");
                        break;
                    }
                
                }
        }
        


    @Override
    public void beginPlay() {
        super.beginPlay();
        AObject playerRef = new PlayerPawn(new Vectors.Vector3D (1000.0,0.0,0.0), this, worldReference);
    }
}