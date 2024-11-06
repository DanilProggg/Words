package com.word.memorization.services;

import com.word.memorization.dtos.WordDto;
import com.word.memorization.entities.KnowledgeLevel;
import com.word.memorization.entities.Word;
import com.word.memorization.exceptions.WordAlreadyExistsException;
import com.word.memorization.repositories.WordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Slf4j
@Service
public class CrudServiceImpl implements CrudService{
    @Autowired
    private WordRepository wordRepository;


    /**
     *
     * @param wordDto dto для слова
     * @param claims jwt.payload
     *
     * @return сообщение об успешном добавлении
     */
    public Word addWord(WordDto wordDto, Map<String,Object> claims){
            if(wordRepository.findByWord(wordDto.getWord()).isPresent()){
                throw new WordAlreadyExistsException();
            }
            Word word = Word.builder()
                    .user_id((Long) claims.get("id"))
                    .word(wordDto.getWord())
                    .language_code(wordDto.getLanguage_code())
                    .translation(wordDto.getTranslation())
                    .knowledgeLevel(KnowledgeLevel.NONE.getValue())
                    .notes(wordDto.getNotes())
                    .difficultyLevel(wordDto.getDifficulty_level())
                    .build();

            wordRepository.save(word);
            return word;
    }

}
