package source.classes.game;

import source.classes.base_classes.Map;
import source.classes.base_classes.AObject;
import source.classes.base_classes.Actor;
import source.classes.base_classes.ClearConsoleObject;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class TicTacToeX_DefaultMap extends Map{
    //constructor --------------------------------------------------------------
    PlayerPawn playerX;
    PlayerPawn playerO;
    TicTacToeXPlayerController playerController;
    TicTacToeXAIController aiController;
    int ticks = 0;
    Timer timer;
    char[] board;
    int turnIndex = 0;  //0 = None, 1 = X, 2 = 0
     

    public TicTacToeX_DefaultMap(Actor owner, AObject worldReference) {
        super(owner, worldReference);
    }

    //functions --------------------------------------------------------------
        public void setTurnIndex(int turnIndex){
            this.turnIndex = turnIndex;
        }
        public void resetBoard(){
            board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
            setTurnIndex(1);
        }
        public void damageLosingPlayer(){
            switch (turnIndex) {
                case 1: playerX.sendDamage((float) (playerX.healthComponent.getMaxHealth()*0.25));
                    break;
                case 2: playerO.sendDamage((float) (playerO.healthComponent.getMaxHealth()*0.25));
                default:
                    break;
            }
        }
    
        //Calculates the turns on board character placement
        public void processTurn(Boolean setTurnIndexTo0){
            if (setTurnIndexTo0){
                turnIndex = 0;
                return;
            }
            switch (turnIndex) {
                case 0: setTurnIndex(0); break;
                case 1: setTurnIndex(2); break;
                case 2: setTurnIndex(1); break;
                default: break;
            }


        }
        //Checks if turn and char is the same
        public boolean doesInputCharRepresentTurn(char inputChar){
            switch (inputChar) {
                case 'X': return turnIndex == 1;
                case 'O': return turnIndex == 2;
            }
            return false;
        }
        //Sets the board value then returns true of false if the placement of value on board has succeeded.
        public boolean setBoardValue(int index, char boardValue){
            boolean success = false;
            if (doesInputCharRepresentTurn(boardValue) == true){  
                if(this.board[index] == ' '){
                    this.board[index]= boardValue;
                    success = true;
                    processTurn(false);
                }   else {
                    success = false;
                    }
                if (checkIfSomeoneHasWonInBoardCombat()){
                    damageLosingPlayer();
                    resetBoard();
                    success = true;
                }
                if (isBoardFull()){
                    delayTime(500);
                    resetBoard();
                }
            }
            refreshDisplay();
            return success;
        }

        
    
    
    
        public char displayWhoseTurnIsIt(){
            if (turnIndex == 1){
                return 'X';
            }
            return 'O';
        }
        public String displayAbilityName(int playerIndex, int abilityIndex){
            if (playerIndex == 0){
                switch (abilityIndex) {
                    case 0: return playerX.abilityQ.getAbilityName();
                    case 1: return playerX.abilityW.getAbilityName();
                    case 2: return playerX.abilityE.getAbilityName(); 
                    case 3: return playerX.abilityR.getAbilityName();
                    default:
                        break;
                }
            }

            if (playerIndex == 1){
                switch (abilityIndex) {
                    case 0: return playerO.abilityQ.getAbilityName(); 
                    case 1: return playerO.abilityW.getAbilityName(); 
                    case 2: return playerO.abilityE.getAbilityName(); 
                    case 3: return playerO.abilityR.getAbilityName(); 
                    default:
                        break;
                }
            }

            return "NULL";
        }
        public int displayAbilityCooldown(int playerIndex, int abilityIndex){
            if (playerIndex == 0){
                switch (abilityIndex) {
                    case 0: return playerX.abilityQ.getCooldown();
                    case 1: return playerX.abilityW.getCooldown();
                    case 2: return playerX.abilityE.getCooldown();
                    case 3: return playerX.abilityR.getCooldown();
                    default:
                        break;
                }
            }

            if (playerIndex == 1){
                switch (abilityIndex) {
                    case 0: return playerO.abilityQ.getCooldown();
                    case 1: return playerO.abilityW.getCooldown();
                    case 2: return playerO.abilityE.getCooldown(); 
                    case 3: return playerO.abilityR.getCooldown();
                    default:
                        break;
                }
            }

            return 9999999;
        }

        public void createDisplay(){
            if  (gameEnded){
                return;
            }
            System.out.println("|----------------------------------------------------- OPPONENT ----------------------------------------------------|\n"+
                                "\n");
                                System.out.printf  ("%-26s%-26s%-26s%-26s%-26s\n", displayAbilityName(1, 0)+ ":" + displayAbilityCooldown(1, 0), displayAbilityName(1, 1) + ":" + displayAbilityCooldown(1, 1), displayAbilityName(1, 2) + ":" + displayAbilityCooldown(1, 2),displayAbilityName(1, 3) + ":" +displayAbilityCooldown(1, 3), "Health: " + playerO.getHealth()); 

            System.out.println ("\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+
                                "                                                      1   2   3  \n"+
                                "                                                    |-----------|\n"+
                                "                                                 1  | "+ this.board[0] +" | "+ this.board[1] +" | "+ this.board[2] +" |\n"+
                                "                                                 2  | "+ this.board[3] +" | "+ this.board[4] +" | "+ this.board[5] +" |\n"+
                                "                                                 3  | "+ this.board[6] +" | "+ this.board[7] +" | "+ this.board[8] +" |\n"+
                                "                                                    |-----------|\n"+
                                "                                                      "+displayWhoseTurnIsIt() + "'s turn\n"+                                             
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n");
     System.out.printf  ("%-26s%-26s%-26s%-26s%-26s\n", displayAbilityName(0, 0)+ ":" + displayAbilityCooldown(0, 0), displayAbilityName(0, 1) + ":" + displayAbilityCooldown(0, 1), displayAbilityName(0, 2) + ":" + displayAbilityCooldown(0, 2),displayAbilityName(0, 3) + ":" +displayAbilityCooldown(0, 3), "Health: " + playerX.getHealth()); 
             System.out.println("\n"+
                                "|------------------------------------------------------- YOU -------------------------------------------------------|\n");
            System.out.println("Enter input: ");

            
                            
        }
        public boolean isBoardFull(){
            for (int i = 0; i <= 8; i++) {
                if (board[i] == ' '){
                    return false;
                }
            }
            return true;
        }
        public boolean checkIfThreeIndicesAreTheSameChar(int n1, int n2, int n3){
            if ((this.board[n1] == this.board[n2]) && (this.board[n2] == this.board[n3]) && (this.board[n1] != ' ')) {
                return true;
            }
            return false;
        }
        public boolean checkIfSomeoneHasWonInBoardCombat(){
            if(
                checkIfThreeIndicesAreTheSameChar(0,1,2)
                ||
                checkIfThreeIndicesAreTheSameChar(3,4,5)
                ||
                checkIfThreeIndicesAreTheSameChar(6,7,8)
                ||
                checkIfThreeIndicesAreTheSameChar(0,3,6)
                ||
                checkIfThreeIndicesAreTheSameChar(1,4,7)
                ||
                checkIfThreeIndicesAreTheSameChar(6,7,8)
                ||
                checkIfThreeIndicesAreTheSameChar(0,4,8)
                ||
                checkIfThreeIndicesAreTheSameChar(6,4,2)
            ){
                return true;
            }
            return false;
        }
        public void refreshDisplay(){
            ClearConsoleObject.clearConsole();
            createDisplay();
        }
        public void tick(Timer timer){
            this.timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run(){
                    refreshDisplay();
                }
            }, 0, 1000);
        }
        public void stopTick(){
            this.timer.cancel();
            ClearConsoleObject.clearConsole();
        }
        boolean gameEnded = false;
        public void setGameOver(Boolean hasPlayerWon, boolean quit){
            if (!gameEnded){
                playerController.close();
                gameEnded = true;
                this.stopTick();
                aiController.close();
                playerO.close();
                playerX.close();
                if (hasPlayerWon && !quit){
                    System.out.println( "|-----------------------------------------------------------------------------------------------------------------------|\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                    ENEMY FELLED                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|-----------------------------------------------------------------------------------------------------------------------|");
                } else if(!hasPlayerWon && !quit){
                    System.out.println( "|-----------------------------------------------------------------------------------------------------------------------|\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                      YOU DIED                                                         |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|                                                                                                                       |\n"+
                    "|-----------------------------------------------------------------------------------------------------------------------|");
                }
                
                
                
                delayTime(2000);
                ClearConsoleObject.clearConsole();
                new TicTacToeX_GameEnder(null, null,true);
            }
            
    }

    //Overide Begin Play --------------------------------------------------------------
    @Override
    public void beginPlay() {
        Random random = new Random();
        float randomEnemyHealth = 50 + random.nextFloat() * (300 - 50);
        
        super.beginPlay();
        playerX = new PlayerPawn(this, this, 'X', 100, "Player");
        playerO = new PlayerPawn(this, this, 'O', randomEnemyHealth, "AI");
        playerController = new TicTacToeXPlayerController(this, this, 'X', playerX);
        aiController = new TicTacToeXAIController(this, this, 'O', playerO);
        playerX.possess(playerController);
        playerO.possess(aiController);
        processTurn(false);

        resetBoard();
        tick(this.timer = new Timer());
        playerController.takeUserInput();
        
    }
}
    
