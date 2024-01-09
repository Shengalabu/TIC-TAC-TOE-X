package source;

import source.classes.Player;

public class GameInstance{
    
    public void Run(){
        Player playerInst = new Player();
        
        System.out.println(playerInst.getHealth());
    }   
}