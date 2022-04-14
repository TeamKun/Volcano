package net.kunmc.lab.volcano.config;

import net.kunmc.lab.configlib.BaseConfig;
import net.kunmc.lab.configlib.value.IntegerValue;
import net.kunmc.lab.configlib.value.LocationValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Config extends BaseConfig {
    public IntegerValue putLavaNum = new IntegerValue(6);
    public IntegerValue putLavaTick = new IntegerValue(150);
    public IntegerValue volcanoWidth = new IntegerValue(40);
    public IntegerValue volcanoNum = new IntegerValue(10);
    public IntegerValue volcanoGrowTick = new IntegerValue(60);
    public IntegerValue volcanoStartRange = new IntegerValue(15);
    public LocationValue createVolcanoPointOnCoordinate = new LocationValue();

    public Config(@NotNull Plugin plugin) {
        super(plugin);
    }
}
