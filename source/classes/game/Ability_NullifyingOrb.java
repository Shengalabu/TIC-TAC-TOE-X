package source.classes.game;

import java.util.Timer;
import java.util.TimerTask;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;

public class Ability_NullifyingOrb extends AbilityBase{
    
    Timer timer1;

    public Ability_NullifyingOrb(Actor owner, AObject worldReference) {
        super(owner, worldReference);
        this.abilityName = "Nullifying Orb";
        this.maxCooldown = 5;
        this.cooldown = 5;
    }

    @Override
    public void executeAbility(){
        getEnemyRef();
        owningPlayerPawn.healthComponent.setInvincible(true);
        super.executeAbility();
        timer1.schedule(new TimerTask(){
            @Override
            public void run(){
                owningPlayerPawn.healthComponent.setInvincible(false);
        }}, 1000);
    }

    @Override
    public void beginPlay(){
        super.beginPlay();
        timer1 = new Timer();
    }

    @Override
    public void close(){
        super.close();
        timer1.cancel();
    }
    
}