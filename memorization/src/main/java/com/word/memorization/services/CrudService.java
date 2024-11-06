package com.word.memorization.services;

import com.word.memorization.dtos.WordDto;
import com.word.memorization.entities.Word;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CrudService {
    Word addWord(WordDto wordDto, Map<String,Object> claims);
}
