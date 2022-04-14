package net.kunmc.lab.volcano.command;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.volcano.Volcano;
import net.kunmc.lab.volcano.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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

        // coordinateモードの初期値設定がされてなければコマンド実行者のplayerの位置を入れるようにする
        Player player = Bukkit.getPlayer(ctx.getSender().getName());
        if (Volcano.getPlugin().config.createVolcanoPointOnCoordinate.value() == null && player != null) {
            Volcano.getPlugin().config.createVolcanoPointOnCoordinate.value(player.getLocation());
        }
        GameManager.controller(GameManager.GameMode.MODE_START);
        ctx.sendSuccess("開始しました");
    }
}
