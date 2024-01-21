package source.classes.game;

import source.classes.base_classes.Actor;
import source.classes.base_classes.ActorComponent;
import source.classes.base_classes.AObject;

public class HealthComponent extends ActorComponent{
    float health;
    float maxHealth;
    
    //constructor
    public HealthComponent(Actor owner, AObject worldReference,float maxHealth) {
        super(owner, worldReference);
        this.health = maxHealth;
        this.maxHealth = maxHealth;
    }
    
    

    //Returns the health of the component
    public float getHealth(){
        return health;
    }

    public float takeDamage(float damage){
        health -= damage;
        if (health <= 0){
            health = 0;
            if (owner.owner instanceof TicTacToeXAIController){
                if(worldReference instanceof TicTacToeX_DefaultMap){
                    ((TicTacToeX_DefaultMap) worldReference).setGameOver(true, false);
                }
            }
            if (owner.owner instanceof TicTacToeXPlayerController){
                if(worldReference instanceof TicTacToeX_DefaultMap){
                    ((TicTacToeX_DefaultMap) worldReference).setGameOver(false, false);
                }
            }
        }
        return health;
    }

    public float getMaxHealth(){
        return maxHealth;
    }

}
