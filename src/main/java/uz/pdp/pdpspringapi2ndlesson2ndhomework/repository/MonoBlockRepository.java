package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Brand;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.MonoBlock;

@RepositoryRestResource(path = "monoBlock",collectionResourceRel = "list")
public interface MonoBlockRepository extends JpaRepository<MonoBlock,Integer> {
    @RestResource(path = "byBrand")
    public Page<MonoBlock> findAllByBrand(Brand brand, Pageable pageable);
    @RestResource(path = "byRam")
    public Page<MonoBlock> findAllByRam(String ram, Pageable pageable);
    @RestResource(path = "byCpu")
    public Page<MonoBlock> findAllByCpu(String cpu, Pageable pageable);
    @RestResource(path = "byDisplaySize")
    public Page<MonoBlock> findAllByDisplaySize(double displaySize, Pageable pageable);
    @RestResource(path = "bySsd")
    public Page<MonoBlock> findAllBySsd(String ssd, Pageable pageable);
    @RestResource(path = "byHdd")
    public Page<MonoBlock> findAllByHdd(String hdd, Pageable pageable);




}
