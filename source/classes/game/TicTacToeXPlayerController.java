package source.classes.game;

import source.classes.base_classes.Actor;
import source.classes.base_classes.PlayerController;
import source.classes.base_classes.math.Vectors;

public class TicTacToeXPlayerController extends PlayerController{
    //constructor
    public TicTacToeXPlayerController(Vectors.Vector3D actorVectors, Actor owner, source.classes.base_classes.AObject worldReference) {
        super(actorVectors, owner, worldReference);
}

    @Override
    public void beginPlay() {
        super.beginPlay();
        PlayerPawn playerRef = new PlayerPawn(new Vectors.Vector3D (1000.0,0.0,0.0), this, worldReference);
    }
}