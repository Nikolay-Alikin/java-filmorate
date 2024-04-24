package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.entity.User;

import java.util.List;

public interface UserStorage {

    User create(User user);

    User update(User user);

    User getById(Long id);

    User delete(Long id);

    List<User> getAll();

}
