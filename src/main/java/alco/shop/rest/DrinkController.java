package alco.shop.rest;

import alco.shop.model.Drink;
import alco.shop.repository.DrinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
public class DrinkController {

    @Autowired
    private DrinkRepository drinkRepository;

    @RequestMapping(value = "/getdrinks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Drink>> getDrinks() {
        List<Drink> drinks = drinkRepository.findAll();
        if (drinks.isEmpty()) {
            log.info(drinks.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info(drinks.toString());
        return new ResponseEntity<>(drinks,HttpStatus.OK);
    }

    @RequestMapping(value = "/getdrinks{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Drink>> getDrinks(@PathVariable Integer id) {
        List<Drink> drinks = drinkRepository.getAllByType(id);
        if (drinks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(drinks,HttpStatus.OK);
    }

}
