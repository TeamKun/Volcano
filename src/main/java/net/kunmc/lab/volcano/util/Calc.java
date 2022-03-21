package net.kunmc.lab.volcano.util;

import java.util.Random;

public class Calc {

    public static Random random = new Random();

    /**
     * -value ~ +valueの範囲の値を返す
     *
     * @param value
     * @return
     */
    public static int getRangeRandomValue(int value) {
        if (value == 0) return 0;
        return random.nextInt(value * 2) - value;
    }

    /**
     * value(任意の整数)とlimitValue（任意の自然数）のうち値が小さいほうを返す
     * 範囲の制限(limitValue)が10の時の例:
     * value:1, limitValue:10 => 1
     * value:11, limitValue:10 => 10
     * value:-1, limitValue:10 => -1
     * value:-11, limitValue:10 => -10
     *
     * @param value      任意の整数
     * @param limitValue 任意の自然数
     * @return
     */
    public static int getRangeMinValue(int value, int limitValue) {
        if (value < 0) {
            return Math.max(value, limitValue * -1);
        } else {
            return Math.min(value, limitValue);
        }
    }
}
