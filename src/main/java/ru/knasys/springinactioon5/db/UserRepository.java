package ru.knasys.springinactioon5.db;

import org.springframework.data.repository.CrudRepository;
import ru.knasys.springinactioon5.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String userName); /* автоматическая генерация реализации этого метода по его названию :) */
}
