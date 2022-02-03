package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Printer;

@RepositoryRestResource(path = "printer",collectionResourceRel = "list")
public interface PrinterRepository extends JpaRepository<Printer,Integer> {
    @RestResource(path = "byBrand")
    public Page<Printer> findAllByBrandName(String brand_name, Pageable pageable);

    @RestResource(path = "byColorful")
    public Page<Printer> findAllByColorful(boolean colorful, Pageable pageable);
    @RestResource(path = "byType")
    public Page<Printer> findAllByType(String type, Pageable pageable);
    @RestResource(path = "bySpeed")
    public Page<Printer> findAllBySpeedPerMinute(double speedPerMinute, Pageable pageable);
    @RestResource(path = "byTypeOfPrinting")
    public Page<Printer> findAllByTypeOfPrinting(String typeOfPrinting, Pageable pageable);
}
