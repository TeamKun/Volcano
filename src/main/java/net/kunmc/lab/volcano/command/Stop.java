package net.kunmc.lab.volcano.command;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.volcano.game.GameManager;

public class Stop extends Command {
    public Stop() {
        super(CommandConst.STOP);
    }

    @Override
    public void execute(CommandContext ctx) {
        if (!GameManager.isRunning()) {
            ctx.sendFailure("開始されていません");
            return;
        }

        GameManager.controller(GameManager.GameMode.MODE_NEUTRAL);
        ctx.sendSuccess("終了しました");
    }
}
