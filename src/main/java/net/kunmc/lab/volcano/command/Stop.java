package net.kunmc.lab.volcano.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.volcano.game.GameManager;

public class Stop extends Command {
    public Stop() {
        super(CommandConst.STOP);
    }

    @Override
    public void execute(CommandContext ctx) {
        if (!GameManager.isRunning()) {
            ctx.fail("開始されていません");
            return;
        }

        GameManager.controller(GameManager.GameMode.MODE_NEUTRAL);
        ctx.success("終了しました");
    }
}
