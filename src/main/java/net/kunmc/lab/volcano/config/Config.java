package net.kunmc.lab.volcano.config;

import net.kunmc.lab.configlib.BaseConfig;
import net.kunmc.lab.configlib.value.IntegerValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Config extends BaseConfig {
    public IntegerValue test = new IntegerValue(180, 1, 1);

    public Config(@NotNull Plugin plugin) {
        super(plugin);
    }
}
