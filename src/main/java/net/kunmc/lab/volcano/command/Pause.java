package net.kunmc.lab.volcano.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;

public class Pause extends Command {
    public Pause() {
        super(CommandConst.PAUSE);
    }

    @Override
    public void execute(CommandContext ctx) {
    }
}
