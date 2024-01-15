package source.classes.game;

import source.classes.base_classes.Actor;
import source.classes.base_classes.AMap;
import source.classes.base_classes.math.Vectors;

public class TicTacToeXAIController extends TicTacToeXPlayerController{
    //Constructor
        public TicTacToeXAIController(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
            super(actorVectors, owner, worldReference);
        }

 


    @Override
    public void beginPlay() {
        super.beginPlay();
        //PlayerPawn playerRef = worldReference.spawnActorFromClass(PlayerPawn.class, new Vectors.Vector3D(-1000,0.0,0.0), owner, worldReference);
    }
}