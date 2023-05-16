package lt.viko.eif.ih.bakery.server;

import lt.viko.eif.ih.bakery.server.model.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Bakery objects.
 */

public interface BakeryRepository extends JpaRepository<Bakery, Long> {

}
