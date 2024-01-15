package source.classes.base_classes;

import source.classes.base_classes.math.Vectors;

public class PlayerController extends Controller{
    //constructor
        public PlayerController(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
            super(actorVectors, owner, worldReference);
        }
}
