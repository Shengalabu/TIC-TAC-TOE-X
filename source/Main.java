package source;

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
        GameInstance activeGameInstance = new GameInstance();
        activeGameInstance.Run();
        System.out.println("HELLO");
        clearConsole();
        
    }
}
