package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Brand;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.GamingChair;

@RepositoryRestResource(path = "gamingChair",collectionResourceRel = "list")
public interface GamingChairRepository extends JpaRepository<GamingChair,Integer> {
    @RestResource(path = "byBrand")
    public Page<GamingChair> findAllByBrand(Brand brand, Pageable pageable);
    @RestResource(path = "byColor")
    public Page<GamingChair> findAllByColor(String color, Pageable pageable);
    @RestResource(path = "byMaxWeight")
    public Page<GamingChair> findAllByMaxWeight(Integer maxWeight, Pageable pageable);
    @RestResource(path = "byBrand")
    public Page<GamingChair> findAllByHeadrest(boolean headrest, Pageable pageable);

}
