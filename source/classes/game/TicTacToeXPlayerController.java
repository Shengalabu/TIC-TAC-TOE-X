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
            Scanner myScanner = new Scanner(System.in);
            String userInput = myScanner.nextLine().toLowerCase();
            switch (userInput) {
                case "11":

                    break;

                default:
                System.out.println("------------------ INVALID INPUT ------------------");
                this.delayTime(1000);
                break;
            }
            myScanner.close();
        }

    @Override
    public void beginPlay() {
        super.beginPlay();
        AObject playerRef = new PlayerPawn(new Vectors.Vector3D (1000.0,0.0,0.0), this, worldReference);
    }
}