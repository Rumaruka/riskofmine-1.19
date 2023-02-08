package com.rumaruka.riskofmine.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;

public class ROMMathFormula {


    public static float powerIncreasing(float x, float y) {

        return Math.abs((float) ROMMathUtils.multiply(x, y)) / 30 - (ROMMathUtils.percent(5) + ROMMathUtils.percent(x * y));


    }

    public static double speedIncreasing(float x) {

        return Math.abs(Math.tan(Math.PI * x / 180));


    }

    public static float explodeIncreasing(float x) {

        return ROMMathUtils.percent(x) - Math.abs(10) / 20f;


    }


}
