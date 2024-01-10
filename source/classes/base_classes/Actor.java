package source.classes.base_classes;

import source.classes.base_classes.math.Vectors;
import source.classes.base_classes.math.Vectors.Vector3D;

//Ignore the yellow squigly lines
//An actor is anything that you can spawn in the world


public class Actor extends AObject {
    //Constructor----------------------------------------------------------------------------
    public Actor owner = null;
    public AObject worldReference = null;
    public Vectors.Vector3D actorLocation;
    public Actor(Vectors.Vector3D actorVectors, Actor owner, AObject worldReference){
        this.actorLocation = actorVectors;
        this.owner = owner;
        this.worldReference = worldReference;
        beginPlay();
    }
    //functions----------------------------------------------------------------------------
        //UserClass testInstance = spawnActorFromClass(UserClass.class, new Vectors.Vector3D(0.0, 0.0, 0.0), this); - Sample usage
        //Spawns actor in a location
        public <T> T spawnActorFromClass(Class<T> clazz, Vectors.Vector3D location, Actor owner, AObject worldReference){
                try{
                    java.lang.reflect.Constructor<T> constructor = clazz.getConstructor(Vectors.Vector3D.class, AObject.class, AObject.class);
                    return constructor.newInstance(location, owner, worldReference);
                } catch  (Exception e){
                    e.printStackTrace();
                    return null;
                }
        }

        public void delayTime(int delayInMilliseconds){
            try {
                Thread.sleep(delayInMilliseconds);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    
    public void beginPlay(){
    }
  
    //Test class for spawnActorFromClass
    public static class UserClass {
        private Vectors.Vector3D vector;
        private AObject owner;

            public UserClass(Vectors.Vector3D vector, AObject owner) {
                this.vector = vector;
                this.owner = owner;
            }
        }
    }