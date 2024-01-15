package source.classes.base_classes;

import source.classes.base_classes.math.Vectors;
import java.util.ArrayList;
import java.util.List;

public class Map extends Actor{
       public Map(Vectors.Vector3D actorVectors, Actor owner, AObject worldReference) {
        super(actorVectors, owner, worldReference);
}

        private List<Actor> ActorVector = new ArrayList<>();

        public void addActorToActorArray(Actor actor){
                this.ActorVector.add(actor);
        }

        public Actor getActorOfClass(Class <?> actorClass){
                for (Actor actor : ActorVector){
                        if (actor.getClass() == actorClass){
                                return actor;
                        }
                }
                return null;
        }

        public boolean removeActorFromRef(Actor actorInstance){
                for (Actor actor : ActorVector){
                        if (actor == actorInstance){
                                ActorVector.remove(actor);
                                return true;
                        }
                }
                return false;
        }
}