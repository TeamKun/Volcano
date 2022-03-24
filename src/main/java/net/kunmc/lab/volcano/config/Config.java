package net.kunmc.lab.volcano.config;

import net.kunmc.lab.configlib.BaseConfig;
import net.kunmc.lab.configlib.value.IntegerValue;
import net.kunmc.lab.configlib.value.StringValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Config extends BaseConfig {
    public IntegerValue putLavaNum = new IntegerValue(3);
    public IntegerValue putLavaTick = new IntegerValue(150);
    public IntegerValue volcanoHeight = new IntegerValue(80);
    public IntegerValue volcanoWeight = new IntegerValue(80);
    public IntegerValue volcanoNum = new IntegerValue(1);
    public IntegerValue volcanoGrowTick = new IntegerValue(120);
    public IntegerValue volcanoStartRange = new IntegerValue(15);
    public StringValue volcanoType = new StringValue("demonstration");

    public Config(@NotNull Plugin plugin) {
        super(plugin);
        volcanoType.addAllowableString("demonstration");
        volcanoType.addAllowableString("normal");
        volcanoType.addAllowableString("hard");
    }
}
