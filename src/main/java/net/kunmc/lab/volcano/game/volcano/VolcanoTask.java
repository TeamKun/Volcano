package net.kunmc.lab.volcano.game.volcano;

import net.kunmc.lab.volcano.Volcano;
import net.kunmc.lab.volcano.util.Calc;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

import static net.kunmc.lab.volcano.util.Calc.getRangeMinValue;
import static net.kunmc.lab.volcano.util.Calc.getRangeRandomValue;

public class VolcanoTask {

    public static List<VolcanoAttribute> volcanoList = new ArrayList();
    private static Map<String, Integer> hardenBlockList = new HashMap();

    private static BukkitTask addVolcanoTask;
    private static BukkitTask growVolcanoTask;
    private static BukkitTask putLavaTask;
    private static BukkitTask hardenBlockTask;

    private static Map<String, Integer> blockHardeningProb = new HashMap<>();

    private static final String OBSIDIAN = "OBSIDIAN";
    private static final String MAGMA = "MAGMA";
    private static final String COBBLESTONE = "COBBLESTONE";
    private static final String IRON_ORE = "IRON_ORE";
    private static final String GOLD_ORE = "GOLD_ORE";
    private static final String DIAMOND_ORE = "DIAMOND_ORE";
    private static int blockHardeningSum = 0;

    static {
        blockHardeningProb.put(OBSIDIAN, 70);
        blockHardeningProb.put(MAGMA, 10);
        blockHardeningProb.put(COBBLESTONE, 10);
        blockHardeningProb.put(IRON_ORE, 5);
        blockHardeningProb.put(GOLD_ORE, 4);
        blockHardeningProb.put(DIAMOND_ORE, 1);
        // 前提として合計値を100%にしているが、あとから変更があっても対応できるように計算しておく
        for (int value : blockHardeningProb.values()) {
            blockHardeningSum += value;
        }
    }

    public static void addVolcanoRunnable() {
        addVolcanoTask = new BukkitRunnable() {
            @Override
            public void run() {
                // 火山作成
                if (volcanoList.size() < Volcano.getPlugin().config.volcanoNum.value()) {
                    VolcanoAttribute volcano = VolcanoCreator.createVolcano();
                    if (volcano != null) volcanoList.add(VolcanoCreator.createVolcano());
                }
                // 火山削除
                ListIterator<VolcanoAttribute> volcanoIterator = volcanoList.listIterator();
                while (volcanoIterator.hasNext()) {
                    VolcanoAttribute volcano = volcanoIterator.next();
                    if (volcano.getCurrentMaxHeight() > volcano.getMaxHeight()) {
                        volcanoIterator.remove();
                    }
                }
            }
        }.runTaskTimer(Volcano.getPlugin(), 0, 5);
    }

    public static void growVolcanoRunnable() {
        growVolcanoTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (VolcanoAttribute volcano : volcanoList) {
                    volcano.growVolcano();
                }
            }
        }.runTaskTimer(Volcano.getPlugin(), 0, Volcano.getPlugin().config.volcanoGrowTick.value());
    }

    public static void putLavaRunnable() {
        putLavaTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (VolcanoAttribute volcano : volcanoList) {
                    for (int i = 0; i < Volcano.getPlugin().config.putLavaNum.value(); i++) {
                        putLava(volcano);
                    }
                }
            }
        }.runTaskTimer(Volcano.getPlugin(), 0, Volcano.getPlugin().config.putLavaTick.value());
    }

    public static void hardenBlockRunnable() {
        hardenBlockTask = new BukkitRunnable() {
            @Override
            public void run() {
                List<String> removeList = new ArrayList<>();
                for (String place : hardenBlockList.keySet()) {
                    if (hardenBlockList.get(place) > 45) {
                        transformBlock(getBlockFromPlace(place));
                        removeList.add(place);
                    } else {
                        hardenBlockList.put(place, hardenBlockList.get(place) + 1);
                    }
                }
                for (String place : removeList) {
                    hardenBlockList.remove(place);
                }
            }
        }.runTaskTimer(Volcano.getPlugin(), 0, 1);
    }

    /**
     * blockを石や鉱石に変更する
     *
     * @param block
     */
    private static void transformBlock(Block block) {
        //if (!block.getType().equals(Material.LAVA)) return;
        // 重み付け選択メモ
        // 抽選を行う -> 外れたら外れた対象がいなかったことにして再抽選

        int rand = Calc.random.nextInt(blockHardeningSum) % blockHardeningSum;
        String hardenBlock = "";
        for (String key : blockHardeningProb.keySet()) {
            if (rand < blockHardeningProb.get(key)) {
                hardenBlock = key;
                break;
            }
            rand -= blockHardeningProb.get(key);
        }

        switch (hardenBlock) {
            case OBSIDIAN:
                block.setType(Material.OBSIDIAN);
                break;
            case MAGMA:
                block.setType(Material.MAGMA_BLOCK);
                break;
            case IRON_ORE:
                block.setType(Material.IRON_ORE);
                break;
            case GOLD_ORE:
                block.setType(Material.GOLD_ORE);
                break;
            case DIAMOND_ORE:
                block.setType(Material.DIAMOND_ORE);
                break;
            default:
                block.setType(Material.COBBLESTONE);
        }
    }

    /**
     * 火山を作るために溶岩を発生させるロジック
     * - 中心に偏るように溶岩を流す(高さの1/3くらいのサイズの範囲でrandom)
     *
     * @param volcano
     */
    public static void putLava(VolcanoAttribute volcano) {
        int pointX = volcano.getPointX();
        int pointZ = volcano.getPointZ();

        // 火山の高さが何割かを計算する(1-(最大の高さ-今の高さ)/最大の高さ))
        // 現在の高さの2/3の範囲でrandomな地点の座標を取得（MaxWeightを超えない値）
        int startX = pointX + getRangeMinValue(getRangeRandomValue((volcano.getCurrentMaxHeight() / 2)), volcano.getMaxWeight());
        int startZ = pointZ + getRangeMinValue(getRangeRandomValue((volcano.getCurrentMaxHeight() / 2)), volcano.getMaxWeight());

        // 溶岩の配置位置
        Location location = Bukkit.getWorld(volcano.getWorld()).getHighestBlockAt(startX, startZ).getLocation();
        location.add(0, 1, 0);
        location.getBlock().setType(Material.LAVA);
    }

    public static void startVolcanoTasks() {
        if (addVolcanoTask == null) addVolcanoRunnable();
        if (growVolcanoTask == null) growVolcanoRunnable();
        if (putLavaTask == null) putLavaRunnable();
        if (hardenBlockTask == null) hardenBlockRunnable();
    }

    public static void stopVolcanoTask() {
        addVolcanoTask.cancel();
        growVolcanoTask.cancel();
        putLavaTask.cancel();
        hardenBlockTask.cancel();

        addVolcanoTask = null;
        growVolcanoTask = null;
        putLavaTask = null;
        hardenBlockTask = null;

        volcanoList.clear();
        hardenBlockList.clear();
    }

    public static void restartTask(String taskName) {
        switch (taskName) {
            case "growVolcanoTick":
                if (growVolcanoTask != null) {
                    growVolcanoTask.cancel();
                }
                growVolcanoTask = null;
                growVolcanoRunnable();
                break;
            case "putLavaTick":
                if (putLavaTask != null) {
                    putLavaTask.cancel();
                }
                putLavaTask = null;
                putLavaRunnable();
                break;
        }
    }

    public static void addHardenBlockList(Location location) {
        String place = location.getWorld().getName() + " " + (int) location.getX() + " " + (int) location.getY() + " " + (int) location.getZ();
        if (!hardenBlockList.containsKey(place)) hardenBlockList.put(place, 0);
    }

    private static Block getBlockFromPlace(String place) {
        String[] placeInfo = place.split(" ");
        return Bukkit.getWorld(placeInfo[0]).getBlockAt(Integer.parseInt(placeInfo[1]), Integer.parseInt(placeInfo[2]), Integer.parseInt(placeInfo[3]));
    }
}
