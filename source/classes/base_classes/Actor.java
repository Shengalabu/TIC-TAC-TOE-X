package source.classes.base_classes;

//An actor is anything that you can spawn in the game.

public class Actor extends AObject {
    //Constructor----------------------------------------------------------------------------
    public Actor owner = null;
    public AObject worldReference = null;
    public Actor(Actor owner, AObject worldReference){
        this.owner = owner;
        this.worldReference = worldReference;
        beginPlay();
    }
    //functions----------------------------------------------------------------------------

        public void delayTime(int delayInMilliseconds){
            try {
                Thread.sleep(delayInMilliseconds);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    
    public void beginPlay(){
    }
  
    }