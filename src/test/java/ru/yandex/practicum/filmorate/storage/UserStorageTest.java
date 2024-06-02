package ru.yandex.practicum.filmorate.storage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import ru.yandex.practicum.filmorate.model.entity.User;
import ru.yandex.practicum.filmorate.storage.dao.UserDao;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase
@TestConstructor(autowireMode = AutowireMode.ALL)
@DisplayName("Тестирование хранилища пользователей")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserStorageTest {

    @Autowired
    private UserDao userDao;

    private static final User testUser = User.builder()
            .email("test@mail")
            .login("test")
            .name("test")
            .birthday(LocalDate.of(2000, 1, 1))
            .build();

    @Test
    @DisplayName("Создание пользователя")
    void createUser() {
        User createdUser = userDao.create(testUser);
        testUser.setId(createdUser.getId());
        User user = userDao.getById(testUser.getId());
        Assertions.assertThat(user).isEqualTo(testUser);
    }

    @Test
    @DisplayName("Обновление пользователя")
    void updateUser() {
        User createdUser = userDao.create(testUser);
        testUser.setId(createdUser.getId());
        testUser.setName("newName");
        User updatedUser = userDao.update(testUser);
        Assertions.assertThat(updatedUser).isEqualTo(testUser);
    }

    @Test
    @DisplayName("Получение пользователя")
    void getUser() {
        User createdUser = userDao.create(testUser);
        testUser.setId(createdUser.getId());
        User user = userDao.getById(testUser.getId());
        Assertions.assertThat(user).isEqualTo(testUser);
    }

    @Test
    @DisplayName("Удаление пользователя")
    void deleteUser() {
        User createdUser = userDao.create(testUser);
        testUser.setId(createdUser.getId());
        User deletedUser = userDao.delete(testUser.getId());
        Assertions.assertThat(deletedUser).isEqualTo(testUser);
    }

    @Test
    @DisplayName("Получение всех пользователей")
    void getAllUsers() {
        User createdUser = userDao.create(testUser);
        testUser.setId(createdUser.getId());
        List<User> users = userDao.getAll();
        Assertions.assertThat(users).contains(testUser);
    }

    @Test
    @DisplayName("Проверка существования пользователя")
    void userExists() {
        User createdUser = userDao.create(testUser);
        testUser.setId(createdUser.getId());
        Assertions.assertThat(userDao.isExists(testUser.getId())).isTrue();
    }
}
