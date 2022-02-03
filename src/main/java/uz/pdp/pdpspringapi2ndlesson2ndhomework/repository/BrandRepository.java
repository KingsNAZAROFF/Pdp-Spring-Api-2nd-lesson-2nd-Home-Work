package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Brand;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Computer;

@RepositoryRestResource(path = "brand",collectionResourceRel = "list")
public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
