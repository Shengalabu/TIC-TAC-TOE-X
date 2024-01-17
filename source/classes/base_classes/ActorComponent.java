package source.classes.base_classes;

//Serves as an easy way to add behavior to an existing actor.
public class ActorComponent extends Actor{
        // Default constructor
        public ActorComponent(Actor owner, AObject worldReference) {
            super(owner, worldReference);
        }
}
