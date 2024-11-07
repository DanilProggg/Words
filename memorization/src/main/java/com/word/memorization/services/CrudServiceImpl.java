package com.word.memorization.services;

import com.word.memorization.dtos.WordDto;
import com.word.memorization.entities.KnowledgeLevel;
import com.word.memorization.entities.Word;
import com.word.memorization.exceptions.WordAlreadyExistsException;
import com.word.memorization.exceptions.WordDoesNotExistsException;
import com.word.memorization.repositories.WordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
     * @return добавленое слово
     */
    @Override
    public Word addWord(WordDto wordDto, Map<String,Object> claims){
            if(wordRepository.findByWord(wordDto.getWord()).isPresent()){
                throw new WordAlreadyExistsException();
            }
            Word word = Word.builder()
                    .userId(((Long) claims.get("id")))
                    .word(wordDto.getWord())
                    .languageCode(wordDto.getLanguage_code())
                    .translation(wordDto.getTranslation())
                    .knowledgeLevel(KnowledgeLevel.NONE.getValue())
                    .notes(wordDto.getNotes())
                    .difficultyLevel(wordDto.getDifficulty_level())
                    .createdAt(new Date())
                    .lastSeen(new Date())
                    .build();

            wordRepository.save(word);
            return word;
    }

    /**
     *
     * @param wordDto dto для слова
     * @param claims jwt.payload
     *
     * Удаляет слово
     */
    @Override
    public void deleteWord(WordDto wordDto, Map<String, Object> claims) {

    }

    /**
     *
     * @param pageNumber Номер страницы
     *
     * @return Список слов
     */
    @Override
    public List<Word> getWords(int pageNumber, Map<String, Object> claims) {
        int pageSize = 10;

        Pageable pageWithLastSeenSort = PageRequest.of(pageNumber - 1, pageSize, Sort.by("lastSeen").descending());
        Page<Word> words = wordRepository.findAllByUserIdOrderByLastSeenDesc((Long) claims.get("id"), pageWithLastSeenSort);
        return words.getContent();
    }
}
