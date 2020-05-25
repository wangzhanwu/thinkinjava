package com.wzw.enums;

public enum OzWitch {
    EAST("east is east"), WEST("west is west"), SOUTH("south is south"), NORTH("north is north");

    private String description;
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + id;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + " : " + witch.getDescription());
        }
        System.out.println(EAST.name() + " : " + EAST.ordinal());
    }
}
