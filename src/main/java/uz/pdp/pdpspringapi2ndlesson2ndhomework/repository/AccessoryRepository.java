package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Accessory;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Brand;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Computer;

@RepositoryRestResource(path = "accessory",collectionResourceRel = "list")
public interface AccessoryRepository extends JpaRepository<Accessory,Integer> {
    @RestResource(path = "byBrand")
    public Page<Accessory> findAllByBrand(Brand brand, Pageable pageable);
    @RestResource(path = "byType")
    public Page<Computer> findAllByType(String type, Pageable pageable);
}
