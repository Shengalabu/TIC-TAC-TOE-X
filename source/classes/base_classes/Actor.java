package source.classes.base_classes;
import source.classes.math.Vectors;

//Ignore the yellow squigly lines
//An actor is anything that you can spawn in the world


public class Actor extends Object {
    //Constructor----------------------------------------------------------------------------
    public Actor(){
        Vectors.Vector3D actorVectors = new Vectors.Vector3D(0.0,0.0,0.0);
        beginPlay();
    }
    //functions----------------------------------------------------------------------------
        //UserClass testInstance = spawnActorFromClass(UserClass.class, new Vectors.Vector3D(0.0, 0.0, 0.0), this); - Sample usage
        //Spawns actor in a location
        public <T> T spawnActorFromClass(Class<T> clazz, Vectors.Vector3D location, Actor owner){
            try{
                java.lang.reflect.Constructor<T> constructor = clazz.getConstructor(Vectors.Vector3D.class, Object.class);
                return constructor.newInstance(location, owner);
            } catch  (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    
    public void beginPlay(){
    }
  
    //Test class for spawnActorFromClass
    public static class UserClass {
        private Vectors.Vector3D vector;
        private Object owner;

            public UserClass(Vectors.Vector3D vector, Object owner) {
                this.vector = vector;
                this.owner = owner;
            }
        }
    }