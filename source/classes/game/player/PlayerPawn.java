package source.classes.player;

import source.classes.interfaces.MasterAttackInterface;
import source.classes.base_classes.Pawn;
import source.classes.components.HealthComponent;

public class PlayerPawn extends Pawn implements MasterAttackInterface{

    //Contruct components here----------------------------------------------------------------------
        HealthComponent healthComponent = new HealthComponent();

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
        }

}
