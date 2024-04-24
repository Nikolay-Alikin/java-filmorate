package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.entity.Film;

import java.util.List;

public interface FilmStorage {

    Film create(Film film);

    Film update(Film film);

    Film getById(Long id);

    Film delete(Long id);

    List<Film> getAll();
}
