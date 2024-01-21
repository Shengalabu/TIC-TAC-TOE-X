package source.classes.game;

import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.ClearConsoleObject;
import source.classes.base_classes.Map;

public class TicTacToeX_GameEnder extends Map{
    public TicTacToeX_GameEnder(Actor owner, AObject worldReference, boolean endGame) {
        super(owner, worldReference);
        ClearConsoleObject.clearConsole();
        exitProgram();
   }

    public void clearThenPrintTextWithDelay(String text, int delayInMilliseconds){
            ClearConsoleObject.clearConsole();
            System.out.println(text);
            delayTime(300);
    }

    public void exitProgram(){
        clearThenPrintTextWithDelay("Cleaning.", 200);
        clearThenPrintTextWithDelay("Cleaning. .", 400);
        clearThenPrintTextWithDelay("Cleaning. . .", 300);
        clearThenPrintTextWithDelay("Cleaning Complete!", 100);
        clearThenPrintTextWithDelay("Exiting Program .", 50);
        clearThenPrintTextWithDelay("Exiting Program . .", 50);
        ClearConsoleObject.clearConsole();
}
   

}
