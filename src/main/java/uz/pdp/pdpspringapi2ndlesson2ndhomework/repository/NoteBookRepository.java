package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Notebook;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Printer;

@RepositoryRestResource(path = "notebook",collectionResourceRel = "list")
public interface NoteBookRepository extends JpaRepository<Notebook,Integer> {
    @RestResource(path = "byBrand")
    public Page<Notebook> findAllByBrandName(String brand_name, Pageable pageable);
    @RestResource(path = "byRam")
    public Page<Notebook> findAllByRam(String ram, Pageable pageable);
    @RestResource(path = "byCpu")
    public Page<Notebook> findAllByCpu(String cpu, Pageable pageable);
    @RestResource(path = "byDisplaySize")
    public Page<Notebook> findAllByDisplaySize(double displaySize, Pageable pageable);
    @RestResource(path = "bySsd")
    public Page<Notebook> findAllBySsd(String ssd, Pageable pageable);
    @RestResource(path = "byGpu")
    public Page<Notebook> findAllByGpu(String gpu, Pageable pageable);
    @RestResource(path = "byHdd")
    public Page<Notebook> findAllByHdd(String hdd, Pageable pageable);






}
