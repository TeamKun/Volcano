package net.kunmc.lab.volcano.game.volcano;

import lombok.Getter;
import net.kunmc.lab.volcano.Volcano;

/**
 * 火山の生成に必要な情報を保持するためのクラス
 * - 生成地点とどこまで成長するかを判定可能な値を保持する
 */
public class VolcanoAttribute {

    @Getter
    private int pointX;
    @Getter
    private int pointY;
    @Getter
    private int pointZ;
    @Getter
    private int currentMaxHeight;
    @Getter
    private String world;

    /**
     * @param startX 開始地点
     * @param startY 開始地点
     * @param startZ 開始地点
     * @param world  火山が存在するworld
     */
    public VolcanoAttribute(int startX, int startY, int startZ, String world) {
        this.pointX = startX;
        this.pointY = startY;
        this.pointZ = startZ;
        this.currentMaxHeight = 0;
        this.world = world;
    }

    public void growVolcano() {
        currentMaxHeight += 1;
    }

    public int getMaxHeight() {
        return Volcano.getPlugin().config.volcanoHeight.value();
    }

    public int getMaxWeight() {
        return Volcano.getPlugin().config.volcanoWeight.value();
    }
}
