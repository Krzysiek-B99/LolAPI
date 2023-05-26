package com.example.leagueoflegendsapi.util;
public class SummonerSpellidToName {

    public static String changeSpellIdToName(int id){
        return switch (id) {
            case 1 -> "Cleanse";
            case 3 -> "Exhaust";
            case 4 -> "Flash";
            case 6 -> "Ghost";
            case 7 -> "Heal";
            case 11 -> "Smite";
            case 12 -> "Teleport";
            case 13 -> "Clarity";
            case 14 -> "Ignite";
            case 21 -> "Barrier";
            case 30 -> "To the King!";
            case 31 -> "Poro Toss";
            case 32, 39 -> "Mark";

            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }
}
