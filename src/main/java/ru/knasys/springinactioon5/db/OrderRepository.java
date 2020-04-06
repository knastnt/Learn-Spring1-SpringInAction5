package ru.knasys.springinactioon5.db;

import org.springframework.data.repository.CrudRepository;
import ru.knasys.springinactioon5.entities.Order;

import java.util.Date;

public interface OrderRepository extends CrudRepository<Order, Long> {
    //офигенная штука - правила именования методов
    Iterable<Order> findOrdersByZipAndPlacedAtAfterOrderByPlacedAt(String zip, Date placedAfter);
    Iterable<Order> findOrdersByZipOrderByPlacedAt(String zip);
}
