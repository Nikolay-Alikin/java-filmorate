package ru.yandex.practicum.filmorate.model.entity.film;

import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.filmorate.model.entity.film.enumerated.Genre;
import ru.yandex.practicum.filmorate.model.entity.film.enumerated.MPA;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class Film {

    private Long id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private Long duration;
    private MPA mpa;
    @Builder.Default
    private Set<Genre> genres = new HashSet<>();
    private final Set<Long> likes = new HashSet<>();

    public Map<String, Object> toMap() {
        return Map.of(
                "name", name,
                "description", description,
                "release_date", releaseDate,
                "duration", duration,
                "mpa_id", mpa.getId()
        );
    }
}
