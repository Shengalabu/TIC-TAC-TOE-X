package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;

public class Ability_SteelTempest extends AbilityBase{
    public Ability_SteelTempest(Actor owner, AObject worldReference) {
        super(owner, worldReference);
        this.abilityName = "Steel Tempest";
        this.maxCooldown = 12;
        this.cooldown = 12;
    }

    @Override
    public void executeAbility(){
        super.executeAbility();
        enemy.sendDamage((float) 8);
    }
    
}