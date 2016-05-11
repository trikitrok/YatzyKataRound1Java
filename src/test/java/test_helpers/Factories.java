package test_helpers;

import com.dodevjutsu.kata.yatzy.core.Dice;
import com.dodevjutsu.kata.yatzy.core.Side;

import java.util.Arrays;

public class Factories {
    public static Dice dice(Side... sides) {
        return new Dice(Arrays.asList(sides));
    }
}
