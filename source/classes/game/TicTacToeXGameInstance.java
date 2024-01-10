package source.classes.game;

import source.classes.base_classes.GameInstance;
import source.classes.base_classes.math.Vectors;
import source.classes.base_classes.Actor;
import source.classes.base_classes.AObject;

public class TicTacToeXGameInstance extends GameInstance{
    //constructor
    public TicTacToeXGameInstance(Vectors.Vector3D actorVectors, Actor owner, AObject worldReference) {
        super(actorVectors, owner, worldReference);
}
    @Override
    public void beginPlay() {
        super.beginPlay();
        AObject tttxPlayerController = new TicTacToeXPlayerController(new Vectors.Vector3D (0.0,0.0,0.0), owner, worldReference);
        AObject tttxAIController = new TicTacToeXAIController(new Vectors.Vector3D (0.0,0.0,0.0), owner, worldReference);
    }
}