package alco.shop.repository;

import alco.shop.model.Drink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Page<Drink> getAllByType(String type, Pageable pageable);

}
