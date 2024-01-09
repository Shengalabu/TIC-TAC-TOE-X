package source;

import source.classes.base_classes.GameInstance;
import source.classes.base_classes.math.Vectors;
import source.classes.game.HealthComponent;
import source.classes.game.TicTacToeX_DefaultMap;

public class Main {

    public static void clearConsole() {
        try {
            // Clear console command for Windows, Unix, and Mac
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
            TicTacToeX_DefaultMap RuntimeMap = new TicTacToeX_DefaultMap(new Vectors.Vector3D (0.0,0.0,0.0), null, null);
    }
}
