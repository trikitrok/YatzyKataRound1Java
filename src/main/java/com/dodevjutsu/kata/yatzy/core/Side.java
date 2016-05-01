package com.dodevjutsu.kata.yatzy.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Side {
    S1, S2, S3, S4, S5, S6;

    @Override
    public String toString() {
        return this.name().substring(1);
    }

    private static final Map<Integer, Side> sidesByNumber;
    static {
        Map<Integer, Side> aMap = new HashMap<>();
        aMap.put(1, S1);
        aMap.put(2, S2);
        aMap.put(3, S3);
        aMap.put(4, S4);
        aMap.put(5, S5);
        aMap.put(6, S6);
        sidesByNumber = Collections.unmodifiableMap(aMap);
    }

    public static Side withNumber(int number) {
        return sidesByNumber.get(number);
    }
}
