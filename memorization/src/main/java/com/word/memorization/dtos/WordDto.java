package com.word.memorization.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "WordDto")
public class WordDto {

    @Schema(description = "слово", example = "hello")
    @Size(max = 100, message = "Слово должно содержать до 100 символов")
    @NotBlank(message = "Слово не может быть пустыми")
    private String word;

    @Schema(description = "Перевод", example = "привет, здравствуйте")
    @Size(max = 200, message = "Перевод должен содержать до 200 символов")
    @NotBlank(message = "Перевод не может быть пустыми")
    private String translation;

    @Schema(description = "Код языка", example = "ru")
    @Size(max = 10, message = "Код языка должен содержать до 10 символов")
    @NotBlank(message = "Код языка не может быть пустыми")
    private String language_code;

    @Schema(description = "Дополнительная информация. Примеры", example = "Приветствие. Например: \"Привет, как дела?\"")
    @Size(max = 400, message = "Информация должена содержать до 400 символов")
    private String notes;

    @Schema(description = "Уровень языка", example = "a2")
    @Size(max = 2, message = "Код языка должен содержать до 2 символов")
    @NotBlank(message = "Уровень языка не может быть пустыми")
    private String difficulty_level;
}
