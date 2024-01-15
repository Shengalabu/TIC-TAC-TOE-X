package source.classes.game;

import source.classes.base_classes.AMap;
import source.classes.base_classes.math.Vectors;
import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.ClearConsoleObject;

import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.Track;

import java.util.Scanner;



public class TicTacToeX_DefaultMap extends AMap{
    //constructor --------------------------------------------------------------
    public TicTacToeX_DefaultMap(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
        super(actorVectors, owner, worldReference);
    }




    //functions --------------------------------------------------------------
        //Set Player Index and reference for the game to know who is X and O.

    //Overide Begin Play --------------------------------------------------------------
    @Override
    public void beginPlay() {
        super.beginPlay();
        TicTacToeXGameInstance GameInstance = this.spawnActorFromClass(TicTacToeXGameInstance.class, new Vectors.Vector3D (-1000.0,0.0,0.0), owner, worldReference);
    }
}
    
