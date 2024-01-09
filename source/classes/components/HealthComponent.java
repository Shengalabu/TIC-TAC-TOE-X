package source.classes.components;
import source.classes.base_classes.ActorComponent;

public class HealthComponent extends ActorComponent{
    float Health = 100;

    //Returns the health of the component
    public float getHealth(){
        return Health;
    }
}
