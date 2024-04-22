package ru.yandex.practicum.filmorate.model.entity;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

/**
 * Film.
 */
@Data
@Builder
public class Film {

    private Long id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private Long duration;
}