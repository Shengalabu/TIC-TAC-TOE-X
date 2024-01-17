package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;

public class Ability_SteelTempest extends AbilityBase{
        public Ability_SteelTempest(Actor owner, AObject worldReference) {
        super(owner, worldReference);
        abilityName = "Steel Tempest";
        maxCooldown = 5;
    }

    
    
}