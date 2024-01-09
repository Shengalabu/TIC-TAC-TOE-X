package source.classes;

public class Player {
    HealthComponent HealthComponent = new HealthComponent();
    float outcome1 = 0;
    float outcome2 = 0;
    float outcome3 = 0;
    float outcome4 = 0;

    int currentStage = 0;
    int currentStageIndex = 0;

    //Returns the health of the player
    public int getHealth(){
        return HealthComponent.getHealth();
    }
}
