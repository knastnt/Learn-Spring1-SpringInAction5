package ru.knasys.springinactioon5.db;

import org.springframework.data.repository.CrudRepository;
import ru.knasys.springinactioon5.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
