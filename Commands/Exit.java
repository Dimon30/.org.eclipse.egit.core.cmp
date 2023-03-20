package Commands;

public class Exit extends Command{
    private static final String name = "exit";
    private static final String description = ": exit;";

    public static void exit(){
        System.exit(0);
    }
}
