package net.kunmc.lab.volcano;

import lombok.Getter;
import net.kunmc.lab.commandlib.CommandLib;
import net.kunmc.lab.configlib.ConfigCommand;
import net.kunmc.lab.configlib.ConfigCommandBuilder;
import net.kunmc.lab.volcano.command.Main;
import net.kunmc.lab.volcano.config.Config;
import net.kunmc.lab.volcano.listener.ConfigListener;
import net.kunmc.lab.volcano.listener.VolcanoEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Volcano extends JavaPlugin {

    @Getter
    private static Volcano plugin;

    public Config config;

    @Override
    public void onEnable() {
        plugin = this;
        // Config
        config = new Config(this);

        // Event
        getServer().getPluginManager().registerEvents(new VolcanoEventListener(), plugin);

        // Command
        ConfigCommand configCommand = new ConfigCommandBuilder(config).build();
        CommandLib.register(this, new Main(configCommand));
        ConfigListener.onModify();
    }

    @Override
    public void onDisable() {
    }
}
