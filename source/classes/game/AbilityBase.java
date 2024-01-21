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
    }

    public void getEnemyRef(){
            if (((PlayerPawn) owner).name.equals("AI")){
                enemy = ((TicTacToeX_DefaultMap) worldReference).playerX;
                return;
            }
            if (((PlayerPawn) owner).name.equals("Player")){
                enemy = ((TicTacToeX_DefaultMap) worldReference).playerO;
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
            executeAbility();
            resetCooldown();
        }
        return;
    }


    public void tickCooldown(){
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (cooldown > 0){
                    decreaseCooldown();
                } else {
                    return;
                }
            }
        }, 0, 1000);
    }

    public void executeAbility(){
        getEnemyRef();
    }


    @Override 
    public void beginPlay(){
        timer = new Timer();
        tickCooldown();

    }

    public void close(){
        if (this.timer != null){
            this.timer.cancel();
        }
    }
}

