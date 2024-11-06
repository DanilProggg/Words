package com.word.memorization.entities;


import lombok.Getter;

public enum KnowledgeLevel {
    NONE(0),
    BAD(1),
    GOOD(2),
    EXCELLENT(3);

    @Getter
    private final int value;

    KnowledgeLevel(int value) {
        this.value = value;
    }
}
