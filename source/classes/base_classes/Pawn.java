package source.classes.base_classes;

//A pawn is anything that can be controlled by the player or the AI.
public class Pawn extends Actor {
        public Pawn(Actor owner, AObject worldReference) {
            super(owner, worldReference);
        }
}
