package ru.knasys.springinactioon5.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.knasys.springinactioon5.entities.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long>, PagingAndSortingRepository<Taco, Long> {
}
