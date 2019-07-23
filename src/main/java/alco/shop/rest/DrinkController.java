package alco.shop.rest;

import alco.shop.model.Drink;
import alco.shop.repository.DrinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller("/products")
public class DrinkController {

    public static final int AMOUNT_PER_PAGE = 10;

    @Autowired
    private DrinkRepository drinkRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PagedResources<Drink>> getDrinks(Integer page, PagedResourcesAssembler assembler) {
        Page<Drink> drinks = drinkRepository.findAll(PageRequest.of(page,AMOUNT_PER_PAGE));
        log.info(String.valueOf(drinks));
        if (drinks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assembler.toResource(drinks),HttpStatus.OK);
    }   

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PagedResources<Drink>> getDrinks(@PathVariable Integer id, Integer page, PagedResourcesAssembler assembler) {
        Page<Drink> drinks = drinkRepository.getAllByType(id, PageRequest.of(page,AMOUNT_PER_PAGE));
        log.info(String.valueOf(drinks));
        if (drinks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assembler.toResource(drinks),HttpStatus.OK);
    }

}
