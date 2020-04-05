package ru.knasys.springinactioon5.db;

import ru.knasys.springinactioon5.entities.Taco;

public interface TacoRepository {
    Taco save(Taco taco);
}
