package source.classes.base_classes;

import source.classes.base_classes.math.Vectors;

public class GameInstance extends Actor{
   public GameInstance(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
        super(actorVectors, owner, worldReference);
}
}