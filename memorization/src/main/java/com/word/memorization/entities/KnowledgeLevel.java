package com.word.memorization.entities;


public enum KnowledgeLevel {
    NONE(0),
    BAD(1),
    GOOD(2),
    EXCELLENT(3);

    private final int value;

    KnowledgeLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
