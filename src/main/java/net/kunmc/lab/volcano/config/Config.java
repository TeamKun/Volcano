package net.kunmc.lab.volcano.config;

import net.kunmc.lab.configlib.BaseConfig;
import net.kunmc.lab.configlib.value.IntegerValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Config extends BaseConfig {
    public IntegerValue putLavaNum = new IntegerValue(4);
    public IntegerValue putLavaTick = new IntegerValue(200);
    public IntegerValue volcanoHeight = new IntegerValue(50);
    public IntegerValue volcanoWeight = new IntegerValue(30);
    public IntegerValue volcanoNum = new IntegerValue(3);
    public IntegerValue volcanoGrowTick = new IntegerValue(200);
    public IntegerValue volcanoStartRange = new IntegerValue(15);

    public Config(@NotNull Plugin plugin) {
        super(plugin);
    }
}
