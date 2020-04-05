package ru.knasys.springinactioon5.db;

import ru.knasys.springinactioon5.entities.Order;

public interface OrderRepository {
    Order save(Order order);
}
