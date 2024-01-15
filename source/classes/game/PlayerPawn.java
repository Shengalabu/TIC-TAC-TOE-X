package source.classes.game;

import source.classes.base_classes.Actor;
import source.classes.base_classes.AMap;
import source.classes.base_classes.Pawn;
import source.classes.base_classes.interfaces.MasterAttackInterface;
import source.classes.base_classes.math.Vectors;

public class PlayerPawn extends Pawn implements MasterAttackInterface{
    
    
    //Contruct components here----------------------------------------------------------------------
    HealthComponent healthComponent = new HealthComponent(new Vectors.Vector3D (0.0,0.0,0.0), this, worldReference);
    Board board;
    
    //constructor
    public PlayerPawn(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
        super(actorVectors, owner, worldReference);
    }

    //Implement interfaces here --------------------------------------------------------------------
        @Override
        public void sendDamage(float damageAmount){
            System.out.println("DamageTaken: " + damageAmount);
        }

    //Declare functions here------------------------------------------------------------------------
        //Returns the health of the player
        public float getHealth(){
            return healthComponent.getHealth();
        }

        public void setBoardRef(Board board){
            this.board = board;
        }

        public Board castToBoard(Actor actor){
            if (actor instanceof Board){
                Board board = (Board) actor;
                return board;
            }
            return null;
        }

    //Begin play overide
        @Override
        public void beginPlay(){
            System.out.println("Player Initiallized");
        }
}
