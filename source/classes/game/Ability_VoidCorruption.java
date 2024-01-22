package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;

public class Ability_VoidCorruption extends AbilityBase{
    public Ability_VoidCorruption(Actor owner, AObject worldReference) {
        super(owner, worldReference);
        this.abilityName = "Void Corruption";
        this.maxCooldown = 20;
        this.cooldown = 20;
    }

    @Override
    public void executeAbility(){
        super.executeAbility();
        enemy.sendDamage((float) 15);
    }

    
    
}