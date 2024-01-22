package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;

public class Ability_VoidRupture extends AbilityBase{
    
    char[] savedBoardData;

    
    public Ability_VoidRupture(Actor owner, AObject worldReference) {
            super(owner, worldReference);
            this.abilityName = "Void Rupture";
            this.maxCooldown = 45;
            this.cooldown = 45;
    }

    public void setBoardValues(int executionIndex){
        switch (executionIndex) {
            case 0:
                savedBoardData[3] = ' ';
                savedBoardData[4] = ' ';
                savedBoardData[5] = ' ';
                break;
            case 1:
                savedBoardData[1] = ' ';
                savedBoardData[4] = ' ';
                savedBoardData[7] = ' ';
            default:
                break;
        }
    }

    @Override
    public void executeAbility(){
        super.executeAbility();
        savedBoardData = tttx_DefaultMap.board;
        setBoardValues(random.nextInt(2));
    }


    
}