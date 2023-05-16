package lt.viko.eif.ih.bakery.server;


import java.util.List;
import java.util.stream.Collectors;

import lt.viko.eif.ih.bakery.server.model.Bakery;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Controller class for managing bakeries.
 */
@RestController
public class BakeryController {

    private final BakeryRepository repository;

    /**
     * Constructs a new instance of the BakeryController.
     *
     * @param repository the repository for accessing bakery data
     */
    BakeryController(BakeryRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves all bakeries.
     *
     * @return a collection of bakeries as EntityModels
     */

    @GetMapping("/bakeries")
    CollectionModel<EntityModel<Bakery>> all() {

        List<EntityModel<Bakery>> bakeries = repository.findAll().stream()
                .map(bakery -> EntityModel.of(bakery,
                        linkTo(methodOn(BakeryController.class).one(bakery.getId())).withSelfRel(),
                        linkTo(methodOn(BakeryController.class).all()).withRel("bakeries")))
                .collect(Collectors.toList());

        return CollectionModel.of(bakeries, linkTo(methodOn(BakeryController.class).all()).withSelfRel());
    }

    /**
     * Creates a new bakery.
     *
     * @param newBakery the bakery object to be created
     * @return the created bakery
     */

    @PostMapping("/bakeries")
    Bakery newBakery(@RequestBody Bakery newBakery) {
        return repository.save(newBakery);
    }

    /**
     * Retrieves a specific bakery by ID.
     *
     * @param id the ID of the bakery to retrieve
     * @return the bakery as an EntityModel
     * @throws BakeryNotFoundException if the bakery with the given ID does not exist
     */

    @GetMapping("/bakeries/{id}")
    EntityModel<Bakery> one(@PathVariable Long id) {

        Bakery bakery = repository.findById(id)
                .orElseThrow(() -> new BakeryNotFoundException(id));

        return EntityModel.of(bakery,
                linkTo(methodOn(BakeryController.class).one(id)).withSelfRel(),
                linkTo(methodOn(BakeryController.class).all()).withRel("bakeries"));
    }

    /**
     * Replaces an existing bakery with new data.
     *
     * @param newBakery the updated bakery data
     * @param id        the ID of the bakery to replace
     * @return the replaced bakery
     */

    @PutMapping("/bakeries/{id}")
    Bakery replaceBakery(@RequestBody Bakery newBakery, @PathVariable Long id) {

        return repository.findById(id) //
                .map(bakery -> {
                    bakery.setName(newBakery.getName());
                    bakery.setAddress(newBakery.getAddress());
                    return repository.save(bakery);
                }) //
                .orElseGet(() -> {
                    newBakery.setId(id);
                    return repository.save(newBakery);
                });
    }

    /**
     * Deletes a specific bakery by ID.
     *
     * @param id the ID of the bakery to delete
     */

    @DeleteMapping("/bakeries/{id}")
    void deleteBakery(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
