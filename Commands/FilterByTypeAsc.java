package Commands;

public class FilterByTypeAsc extends Command{
    private static final String name = "filter_greater_than_type";
    private final static String description = ": ;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void history(Iterable<String> history) {
        history.forEach(System.out::println);
    }
}
