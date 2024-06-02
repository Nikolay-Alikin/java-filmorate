package ru.yandex.practicum.filmorate.service;

import ru.yandex.practicum.generated.model.dto.MPADTO;

import java.util.List;

public interface MpaService {

    List<MPADTO> getAll();

    MPADTO getMpaById(Long id);
}
