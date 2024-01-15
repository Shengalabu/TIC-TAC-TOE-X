package source.classes.base_classes;

import source.classes.base_classes.math.Vectors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class AMap extends Actor{
        
        private List<Actor> ActorList;
        
        //Constructor
        public AMap(Vectors.Vector3D actorVectors, Actor owner, AMap worldReference) {
        super(actorVectors, owner, worldReference);
        }

        //Functions
        public Actor getActorOfClass(Class <?> actorClass){
                for (Actor actor : ActorList){
                        if (actor.getClass() == actorClass){
                                return actor;
                        }
                }
                return null;
        }

        public boolean removeActorFromRef(Actor actorInstance){
                for (Actor actor : ActorList){
                        if (actor == actorInstance){
                                ActorList.remove(actor);
                                return true;
                        }
                }
                return false;
        }

        public <T extends Actor> T spawnActorFromClass(Class<T> actorClass, Vectors.Vector3D location, Actor owner, AMap worldReference) {
                try {
                        Constructor<T> constructor = actorClass.getDeclaredConstructor(Vectors.Vector3D.class, Actor.class, AMap.class);
                        T actorInstance = constructor.newInstance(location, owner, worldReference);
                        
                        ActorList.add(actorInstance);
                        return actorInstance;
                
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();                
                        }
                return null;
        }

        @Override
        public void beginPlay() {
        // TODO Auto-generated method stub
                super.beginPlay();
                ActorList = new ArrayList<>();
        }
}