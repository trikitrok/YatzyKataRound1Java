package com.dodevjutsu.kata.yatzy.infrastructure.die_rollers;

import com.dodevjutsu.kata.yatzy.core.Side;
import com.dodevjutsu.kata.yatzy.core.DieRoller;

import java.util.Random;

public class RandomDieRoller implements DieRoller {
    Random rn = new Random();

    @Override
    public Side roll() {
        int num = rn.nextInt(6) + 1;
        return Side.withNumber(num);
    }
}
