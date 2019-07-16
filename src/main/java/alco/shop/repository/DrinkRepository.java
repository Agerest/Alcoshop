package alco.shop.repository;

import alco.shop.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    public List<Drink> getAllByType(Integer type);

}
