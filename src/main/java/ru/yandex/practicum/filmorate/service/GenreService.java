package ru.yandex.practicum.filmorate.service;

import ru.yandex.practicum.generated.model.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    List<GenreDTO> getAll();

    GenreDTO getGenreById(Long id);
}
