package net.kunmc.lab.volcano.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.volcano.game.GameManager;

public class Start extends Command {
    public Start() {
        super(CommandConst.START);
    }

    @Override
    public void execute(CommandContext ctx) {
        if (GameManager.isRunning()) {
            ctx.fail("既に開始しています");
        }

        GameManager.controller(GameManager.GameMode.MODE_START);
        ctx.success("開始しました");
    }
}
