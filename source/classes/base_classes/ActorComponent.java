package source.classes.base_classes;

import source.classes.base_classes.math.Vectors;

public class ActorComponent extends Actor{
        // Default constructor
        public ActorComponent(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
            super(actorVectors, owner, worldReference);
        }
}
