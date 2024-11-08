package com.word.memorization.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_id_seq")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "word", nullable = false)
    private String word;

    @Column(name = "language_code", nullable = false)
    private String languageCode;

    @Column(name = "translation", nullable = false)
    private String translation;

    @Column(name = "knowledge_level", nullable = false)
    private int knowledgeLevel;

    @Column(name = "notes", nullable = false)
    private String notes;

    @Column(name = "difficulty_level", nullable = false)
    private String difficultyLevel;

    @Column(name = "last_seen", nullable = true)
    private Date lastSeen;

    @Column(name = "create_at", nullable = false)
    private Date createdAt;
}

