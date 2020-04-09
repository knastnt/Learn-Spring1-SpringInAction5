package ru.knasys.springinactioon5.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.knasys.springinactioon5.entities.Order;
import ru.knasys.springinactioon5.entities.User;

import java.util.Date;

public interface OrderRepository extends CrudRepository<Order, Long> {
    //офигенная штука - правила именования методов
//    Iterable<Order> findOrdersByZipAndPlacedAtAfterOrderByPlacedAt(String zip, Date placedAfter);
    Page<Order> findOrdersByUserOrderByPlacedAtDesc(User user, Pageable pageable);
    Page<Order> findOrdersByUserAndZipOrderByPlacedAtDesc(User user, String zip, Pageable pageable);
}
