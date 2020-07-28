package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Play {
    private Map<String, SpecificPlay> playMap;

    @Data
    @AllArgsConstructor
    public static class SpecificPlay {
        private String name;
        private String type;
    }

    public static Play createTestPlay() {
        Play play = new Play();
        Map<String, SpecificPlay> map = new HashMap<>();
        map.put("hamlet", new SpecificPlay("Hamlet", "tragedy"));
        map.put("as-like", new SpecificPlay("As you Like It", "comedy"));
        map.put("othello", new SpecificPlay("Othello", "tragedy"));

        play.setPlayMap(map);
        return play;
    }
}
