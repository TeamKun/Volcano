package net.kunmc.lab.volcano.command;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.volcano.game.GameManager;

public class Start extends Command {
    public Start() {
        super(CommandConst.START);
    }

    @Override
    public void execute(CommandContext ctx) {
        if (GameManager.isRunning()) {
            ctx.sendFailure("既に開始しています");
            return;
        }

        GameManager.controller(GameManager.GameMode.MODE_START);
        ctx.sendSuccess("開始しました");
    }
}
