package Commands;

import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface CommandInt{
    void runCommand();
}
public abstract class Command {
    private static Map<String, Command> commandMap = new HashMap<String, Command>();
    public static void command(String line) {
        commandMap.get(line);
    }
}