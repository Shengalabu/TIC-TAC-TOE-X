package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import java.util.Timer;
import java.util.TimerTask;

public class AbilityBase extends Actor{
    String abilityName = "None";
    int maxCooldown = 50;
    int cooldown = 0;
    Timer timer;
    PlayerPawn enemy;

    public AbilityBase(Actor owner, AObject worldReference) {
        super(owner, worldReference);
        if (worldReference instanceof TicTacToeX_DefaultMap){
            if (owner.owner instanceof TicTacToeXAIController){
                enemy = ((TicTacToeX_DefaultMap) worldReference).playerX;
            }
            if (owner.owner instanceof TicTacToeXPlayerController){
                enemy = ((TicTacToeX_DefaultMap) worldReference).playerO;
            }
        }
    }

    public String getAbilityName(){
        return abilityName;
    }
    public int getCooldown(){
        return cooldown;
    }
    public void resetCooldown(){
        cooldown = maxCooldown;
    }
    public void decreaseCooldown(){
        cooldown--;
    }

    public void tryRunAbility(){
        if (cooldown == 0){
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (cooldown > 0){
                        decreaseCooldown();
                    } else {
                        timer.purge();
                        timer.cancel();
                    }
                }
            }, 0, 1000);
            executeAbility();
            resetCooldown();

        }
    }
    public void executeAbility(){
    }

    @Override 
    public void beginPlay(){
        timer = new Timer();
    }
}

