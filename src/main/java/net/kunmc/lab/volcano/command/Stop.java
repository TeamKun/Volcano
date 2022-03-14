package net.kunmc.lab.volcano.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;

public class Stop extends Command {
    public Stop() {
        super(CommandConst.STOP);
    }

    @Override
    public void execute(CommandContext ctx) {
    }
}
