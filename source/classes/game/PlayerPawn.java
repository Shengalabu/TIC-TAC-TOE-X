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

    AbilityBase abilityQ;
    AbilityBase abilityW;
    AbilityBase abilityE;
    AbilityBase abilityR;


    //constructor
    public PlayerPawn(Actor owner, AObject worldReference, char TicTacToeValue, float MaxHealth) {
        super(owner, worldReference);
        this.TicTacToeValue = TicTacToeValue;
        if (worldReference instanceof TicTacToeX_DefaultMap) {
            tttx_DefaultMap = (TicTacToeX_DefaultMap) worldReference;
            healthComponent = new HealthComponent(this, worldReference, MaxHealth);
        }
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
            abilityQ = new Ability_SteelTempest(this, tttx_DefaultMap);
            abilityW = new AbilityBase(this, tttx_DefaultMap);
            abilityE = new AbilityBase(this, tttx_DefaultMap);
            abilityR = new AbilityBase(this, tttx_DefaultMap);
        }

}
