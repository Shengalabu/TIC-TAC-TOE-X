package source.classes.base_classes;

import source.classes.base_classes.math.Vectors;

//The soul that possesses a pawn
public class Controller extends Actor{
    //constructor
        public Controller(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
            super(actorVectors, owner, worldReference);
        }
}
