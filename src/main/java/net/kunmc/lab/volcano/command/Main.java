package net.kunmc.lab.volcano.command;

import dev.kotx.flylib.command.Command;
import net.kunmc.lab.configlib.ConfigCommand;

public class Main extends Command {
    public Main(ConfigCommand configCommand) {
        super(CommandConst.MAIN);
        children(new Start(), new Stop(), configCommand);
    }
}
