package Commands;

public class Help extends Command{

    private static final String name = "help";
    private static final String description = ": Output all commands;";

    public static void help(){
        System.out.println("-" + getName() + getDescription());
        System.out.println("-" + Info.getName() + Info.getDescription());
        System.out.println("-" + Show.getName() + Show.getDescription());
        System.out.println("-" + Add.getName() + Add.getDescription());
        System.out.println("-" + Update.getName() + Update.getDescription());
        System.out.println("-" + Remove.getName() + Remove.getDescription());
        System.out.println("-" + Clear.getName() + Clear.getDescription());
        System.out.println("-" + Save.getName() + Save.getDescription());
        /*System.out.println("-" + Info.getName() + getDescription());
        System.out.println("-" + Info.getName() + getDescription());
        System.out.println("-" + Info.getName() + getDescription());
        System.out.println("-" + Info.getName() + getDescription());
        System.out.println("-" + Info.getName() + getDescription());
        System.out.println("-" + Info.getName() + getDescription());
        System.out.println("-" + Info.getName() + getDescription());*/

    }


    public static String getName(){return name;}
    public static String getDescription(){return description;}

}
