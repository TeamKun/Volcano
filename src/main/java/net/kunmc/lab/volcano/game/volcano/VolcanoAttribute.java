package net.kunmc.lab.volcano.game.volcano;

import lombok.Getter;
import lombok.Setter;

/**
 * 火山の生成に必要な情報を保持するためのクラス
 * - 生成地点とどこまで成長するかを判定可能な値を保持する
 */
public class VolcanoAttribute {

    private int pointX;
    @Getter
    private int pointY;
    @Getter
    private int pointZ;
    @Getter
    @Setter
    private int currentMaxHeight;
    @Getter
    private String world;
    @Getter
    private int growCnt;


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
        this.growCnt = 0;
    }

    public void growVolcano() {
        growCnt++;
        if (growCnt > 400) {
            growCnt = 0;
            currentMaxHeight++;
        }
    }

    public int getMaxHeight() {
        return 30;
    }

    public int getMaxWeight() {
        return 30;
    }

    public int getPointX() {
        return pointX;
    }
}
