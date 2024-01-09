package source.classes.game;

import source.classes.base_classes.Actor;
import source.classes.base_classes.ActorComponent;
import source.classes.base_classes.math.Vectors;

public class HealthComponent extends ActorComponent{
    //constructor
    public HealthComponent(Vectors.Vector3D actorVectors, Actor owner, source.classes.base_classes.AObject worldReference) {
        super(actorVectors, owner, worldReference);
    }
    float Health = 100;

    //Returns the health of the component
    public float getHealth(){
        return Health;
    }
}
