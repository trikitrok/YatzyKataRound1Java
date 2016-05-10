package com.dodevjutsu.kata.yatzy.infrastructure.input_readers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputLine {
    private final String line;
    private static final Map<String, Integer> indexesByDieRepresentation = new HashMap<>();

    static {
        indexesByDieRepresentation.put("D1", 0);
        indexesByDieRepresentation.put("D2", 1);
        indexesByDieRepresentation.put("D3", 2);
        indexesByDieRepresentation.put("D4", 3);
        indexesByDieRepresentation.put("D5", 4);
    }

    public InputLine(String line) {
        this.line = line;
    }

    public List<Integer> extractDiceIndexes() {
        String[] dieRepresentations = line.split(" ");
        return Stream.of(dieRepresentations)
            .map(this::dieRepresentationToIndex)
            .collect(Collectors.toList());
    }

    private int dieRepresentationToIndex(String token) {
        if(!indexesByDieRepresentation.containsKey(token)) {
            throw new WrongInputException(line);
        }
        return indexesByDieRepresentation.get(token);
    }
}
