package com.rumaruka.riskofmine.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;

public class ROMMathFormula {

    /**
      @apiNote This Math Class for mod
      <ul> powerIncreasing - method powerIncreasing(
      @param x  - first parameter,
      @param y - second parameter, @param
      @param percent - percent ¯\_(ツ)_/¯)</ul>
     * speedIncreasing - method for ENERGY_DRINK
     * explodeIncreasing - method for STICKY_BOMB
     */
    public static float powerIncreasing(float x, float y, int percent) {

        return Math.abs((float) ROMMathUtils.multiply(x, y)) / 30 - (ROMMathUtils.percent(percent) + ROMMathUtils.percent(x * y));


    }

    public static double speedIncreasing(float x) {

        return Math.abs(Math.tan(Math.PI * x / 180));


    }

    public static float explodeIncreasing(float x) {

        return ROMMathUtils.divide(ROMMathUtils.percent(x) - Math.abs(10), 2);


    }


}
