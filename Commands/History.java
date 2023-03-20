package Commands;

public class History {
    private static final String name = "history";
    private final static String description = ": Show 8 last commands;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void history(Iterable<String> history) {
        history.forEach(System.out::println);
    }
}
