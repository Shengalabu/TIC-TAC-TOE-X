package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.math.Vectors;

public class TicTacToeXAIController extends TicTacToeXPlayerController{
    //Constructor
        public TicTacToeXAIController(Vectors.Vector3D actorVectors, Actor owner, AObject worldReference) {
            super(actorVectors, owner, worldReference);
        }

 


    @Override
    public void beginPlay() {
        super.beginPlay();
        //AObject playerRef = new PlayerPawn(new Vectors.Vector3D (-1000.0,0.0,0.0), this, worldReference);
    }
}