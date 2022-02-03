package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Peripheral;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Printer;

@RepositoryRestResource(path = "peripheral",collectionResourceRel = "list")
public interface PeripheralRepository extends JpaRepository<Peripheral,Integer> {

    @RestResource(path = "byBrand")
    public Page<Peripheral> findAllByBrandName(String brand_name, Pageable pageable);
    @RestResource(path = "byType")
    public Page<Peripheral> findAllByType(String type, Pageable pageable);
}
