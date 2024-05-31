package ru.yandex.practicum.filmorate.storage.inmemory;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.model.entity.User;
import ru.yandex.practicum.filmorate.storage.UserStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryUserStorage implements UserStorage {

    private Long id = 0L;

    private final Map<Long, User> users = new HashMap<>();

    @Override
    public User create(User user) {
        user.setId(++id);
        users.put(id, user);
        return user;
    }

    @Override
    public User update(User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public User getById(Long id) {
        return users.get(id);
    }

    @Override
    public User delete(Long id) {
        return users.remove(id);
    }

    @Override
    public List<User> getAll() {
        return users.values().stream().toList();
    }

    @Override
    public boolean isExists(Long id) {
        return users.containsKey(id);
    }
}