package source.classes.game;

import source.classes.base_classes.GameInstance;
import source.classes.base_classes.math.Vectors;
import source.classes.base_classes.Actor;
import source.classes.base_classes.AMap;

public class TicTacToeXGameInstance extends GameInstance{
    //constructor
    public TicTacToeXGameInstance(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
        super(actorVectors, owner, worldReference);
    }




    Board board; 

    @Override
    public void beginPlay() {
        super.beginPlay();
        board = worldReference.spawnActorFromClass(Board.class, new Vectors.Vector3D (-1000.0,0.0,0.0), owner, worldReference);
       // TicTacToeXPlayerController tttxPlayerController = worldReference.spawnActorFromClass(TicTacToeXPlayerController.class, new Vectors.Vector3D (-1000.0,0.0,0.0), owner, worldReference);
       // TicTacToeXAIController tttxAIController = worldReference.spawnActorFromClass(TicTacToeXAIController.class, new Vectors.Vector3D (-1000.0,0.0,0.0), owner, worldReference);
       // tttxPlayerController.setNewBoardValue(board);
       // tttxAIController.setNewBoardValue(board);
    }
}