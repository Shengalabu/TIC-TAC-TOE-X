package source.classes.base_classes;


//The actual player or AI that possesses a pawn.
public class Controller extends Actor{
    //constructor
        public Controller(Actor owner, AObject worldReference) {
            super(owner, worldReference);
        }
}
