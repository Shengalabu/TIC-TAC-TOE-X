package source.classes.base_classes;

import source.classes.base_classes.math.Vectors;

//A pawn is anything that can be controlled by the player or the AI
public class Pawn extends Actor {
        public Pawn(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
            super(actorVectors, owner, worldReference);
        }
}
