package com.word.memorization.controllers;

import com.word.memorization.components.JwtTokenProvider;
import com.word.memorization.dtos.JsonResponse;
import com.word.memorization.dtos.WordDto;
import com.word.memorization.entities.Word;
import com.word.memorization.exceptions.WordAlreadyExistsException;
import com.word.memorization.services.CrudServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
@Slf4j
@Tag(name = "Crud")
public class CrudController {

    @Autowired
    private CrudServiceImpl crudService;
    @Autowired JwtTokenProvider jwtTokenProvider;


    @PostMapping("/add")
    @Operation(summary = "Add word")
    public ResponseEntity<?> addWord(@RequestBody @Valid WordDto wordDto){
        try{

            crudService.addWord(wordDto, jwtTokenProvider.getClaims());
            return ResponseEntity.ok(new JsonResponse("Word add successful"));

        } catch (WordAlreadyExistsException e) {

            log.error(
                    String.format("Word \"%s\" already exists. Error: %s",
                            wordDto.getWord(), e.getMessage())
            );

            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    String.format("Word \"%s\" already exists. Error: %s",
                            wordDto.getWord(), e.getMessage())
            );

        } catch (Exception e){

            log.error(
                    String.format("An unexpected error occurred. Error: %s",
                            e.getMessage()
                    )
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    String.format("An unexpected error occurred. Error: %s",
                            e.getMessage()
                    )
            );

        }
    }
    @PostMapping("/get/{page}")
    @Operation(description = "Get page with words")
    public ResponseEntity<?> getWords(@PathVariable int page){
        try {
            List<Word> list = crudService.getWords(page, jwtTokenProvider.getClaims());
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
