package source.classes.game;

import source.classes.base_classes.Actor;
import source.classes.base_classes.AObject;
import source.classes.base_classes.Pawn;
import source.classes.base_classes.interfaces.MasterAttackInterface;

public class PlayerPawn extends Pawn implements MasterAttackInterface{
    char TicTacToeValue = 'X';
    TicTacToeX_DefaultMap tttx_DefaultMap;
    TicTacToeXPlayerController tttx_PlayerController;
    HealthComponent healthComponent;
    String name = "None";

    AbilityBase abilityQ;
    AbilityBase abilityW;
    AbilityBase abilityE;
    AbilityBase abilityR;


    //constructor
    public PlayerPawn(Actor owner, AObject worldReference, char ticTacToeValue, float maxHealth, String name) {
        super(owner, worldReference);
        this.TicTacToeValue = ticTacToeValue;
        if (worldReference instanceof TicTacToeX_DefaultMap) {
            tttx_DefaultMap = (TicTacToeX_DefaultMap) worldReference;
            healthComponent = new HealthComponent(this, worldReference, maxHealth);
        }
        this.name = name;
    }

    //Contruct components here----------------------------------------------------------------------

    //Implement interfaces here --------------------------------------------------------------------
        @Override
        public void sendDamage(float damageAmount){
            healthComponent.takeDamage(damageAmount);
        }

    //Declare functions here------------------------------------------------------------------------
        //Returns the health of the player
        public float getHealth(){
            return healthComponent.getHealth();
        }
    
        public void possess (TicTacToeXPlayerController tttx_PlayerController){
            this.tttx_PlayerController = tttx_PlayerController;
            this.owner = tttx_PlayerController;
        }

    //Begin play overide
        @Override
        public void beginPlay(){
            abilityQ = new Ability_SteelTempest(this, worldReference);
            abilityW = new Ability_NullifyingOrb(this, worldReference);
            abilityE = new Ability_VoidCorruption(this, worldReference);
            abilityR = new Ability_VoidRupture(this, worldReference);
        }

        public void close(){
            abilityQ.close();
            abilityW.close();
            abilityE.close();
            abilityR.close();
        }
}
