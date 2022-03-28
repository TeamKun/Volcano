package net.kunmc.lab.volcano.config;

import net.kunmc.lab.configlib.BaseConfig;
import net.kunmc.lab.configlib.value.IntegerValue;
import net.kunmc.lab.configlib.value.StringValue;
import net.kunmc.lab.configlib.value.tuple.Integer2IntegerPairValue;
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
    public StringValue volcanoType = new StringValue(ConfigConst.VOLCANO_TYPE_DEMONSTRATION);
    public StringValue createVolcanoType = new StringValue(ConfigConst.CREATE_VOLCANO_TYPE_PLAYER);
    public StringValue volcanoWorld = new StringValue("world");
    public Integer2IntegerPairValue createVolcanoPointOnCoordinate = new Integer2IntegerPairValue(0, 0);

    public Config(@NotNull Plugin plugin) {
        super(plugin);
        volcanoType.addAllowableString(ConfigConst.VOLCANO_TYPE_DEMONSTRATION);
        volcanoType.addAllowableString(ConfigConst.VOLCANO_TYPE_NORMAL);
        volcanoType.addAllowableString(ConfigConst.VOLCANO_TYPE_HARD);
        createVolcanoType.addAllowableString(ConfigConst.CREATE_VOLCANO_TYPE_COORDINATE);
        createVolcanoType.addAllowableString(ConfigConst.CREATE_VOLCANO_TYPE_PLAYER);
        volcanoWorld.addAllowableString("world");
        volcanoWorld.addAllowableString("world_nether");
        volcanoWorld.addAllowableString("world_the_end");
    }
}
