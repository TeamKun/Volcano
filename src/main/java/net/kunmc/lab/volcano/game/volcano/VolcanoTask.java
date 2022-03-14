package net.kunmc.lab.volcano.game.volcano;

import net.kunmc.lab.volcano.Volcano;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.kunmc.lab.volcano.util.Calc.getRangeMinValue;
import static net.kunmc.lab.volcano.util.Calc.getRangeRandomValue;

public class VolcanoTask {

    private static List<VolcanoAttribute> volcanoList = new ArrayList();

    private static BukkitTask addVolcanoTask;
    private static BukkitTask putMagmaTask;

    public static void addVolcanoRunnable() {
        addVolcanoTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (volcanoList.size() < 3) {
                    System.out.println(Bukkit.getOnlinePlayers());
                    Player player = Bukkit.getPlayer("POne0301");
                    if (player == null) return;
                    volcanoList.add(VolcanoCreator.createVolcano(player));
                }
            }
        }.runTaskTimer(Volcano.getPlugin(), 0, 5);
    }

    public static void putMagmaRunnable() {
        putMagmaTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (VolcanoAttribute volcano : volcanoList) {
                    putLava(volcano);
                }
            }
        }.runTaskTimer(Volcano.getPlugin(), 0, 100);
    }

    /**
     * 火山を作るために溶岩を発生させるロジック
     * - 山の高さによって溶岩の発生ロジックを変える
     * - 50%未満の高さの時溶岩が中心に偏るように溶岩を流す(高さの2/3くらいのサイズの範囲でrandom)
     * - 50%以上の高さの時溶岩が山の頂上から全体に流れるように溶岩を流す
     *
     * @param volcano
     */
    public static void putLava(VolcanoAttribute volcano) {
        int pointX = volcano.getPointX();
        int pointZ = volcano.getPointZ();

        // 火山の高さが何割かを計算する(1-(最大の高さ-今の高さ)/最大の高さ))
        double volcanoHeight = 1.0 - ((double) (volcano.getMaxHeight() - volcano.getCurrentMaxHeight())) / volcano.getMaxHeight();
        System.out.println(volcanoHeight);
        if (volcanoHeight < 0.5) {
            // 現在の高さの2/3の範囲でrandomな地点の座標を取得（MaxWeightを超えない値）
            int startX = getRangeMinValue(pointX + getRangeRandomValue((int) (volcanoHeight * 2 / 3)), volcano.getMaxWeight());
            int startZ = getRangeMinValue(pointZ + getRangeRandomValue((int) (volcanoHeight * 2 / 3)), volcano.getMaxWeight());

            // StartX, ZからpointX, Zに向かって探索して、ブロックがおける地点にブロック配置
            // 溶岩の配置位置
            Location targetLoc = null;
            Block block = Bukkit.getWorld(volcano.getWorld()).getHighestBlockAt(startX, startZ);
            //if (canPutLavaBlockList.contains(block.getType())) {
            //}
            //if (targetLoc != null) {
            //    targetLoc.add(0, 1, 0).getBlock().setType(Material.LAVA);
            //}
            System.out.println("AAAA");
            targetLoc = block.getLocation();
            targetLoc.add(0, 1, 0).getBlock().setType(Material.LAVA);
        }
        volcano.growVolcano();
    }

    private static final Set<Material> canPutLavaBlockList = new HashSet<Material>() {{
        add(Material.AIR);
        add(Material.CAVE_AIR);
        add(Material.VOID_AIR);
    }};
}
