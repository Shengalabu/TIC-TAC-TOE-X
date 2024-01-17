package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

public class TicTacToeXAIController extends TicTacToeXPlayerController {
    Random random = new Random();
    Timer timer;

        public TicTacToeXAIController(Actor owner, AObject worldReference, char TicTacToeValue, PlayerPawn player) {
            super(owner, worldReference, TicTacToeValue, player);
        }
        /*
        @Override
        public void takeUserInput(){
            placeCharOnBoard(random.nextInt(9));
        }
        */

        
        @Override
        public void beginPlay(){
            timer = new Timer();
            random = new Random();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (tttx_DefaultMap.turnIndex == 2){
                        placeCharOnBoard(random.nextInt(9));
                    }
                }
            }, 0, random.nextInt(1300));
        }
         
}
