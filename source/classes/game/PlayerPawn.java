package source.classes.game;

import source.classes.base_classes.Actor;
import source.classes.base_classes.AMap;
import source.classes.base_classes.AObject;
import source.classes.base_classes.Pawn;
import source.classes.base_classes.interfaces.MasterAttackInterface;
import source.classes.base_classes.math.Vectors;

public class PlayerPawn extends Pawn implements MasterAttackInterface{
    //constructor
    public PlayerPawn(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
        super(actorVectors, owner, worldReference);
    }

        //Contruct components here----------------------------------------------------------------------
        HealthComponent healthComponent = new HealthComponent(new Vectors.Vector3D (0.0,0.0,0.0), this, worldReferenceClass);

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

    //Begin play overide
        @Override
        public void beginPlay(){
            System.out.println("Player Initiallized");

        }
}
