package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Computer;


@RepositoryRestResource(path = "computer",collectionResourceRel = "list")
public interface ComputerRepository extends JpaRepository<Computer,Integer> {
    @RestResource(path = "byMotherBoard")
    public Page<Computer> findAllByMotherBoard(String motherBoard, Pageable pageable);
    @RestResource(path = "byRam")
    public Page<Computer> findAllByRam(String ram, Pageable pageable);
    @RestResource(path = "byCpu")
    public Page<Computer> findAllByCpu(String cpu, Pageable pageable);
    @RestResource(path = "byGpu")
    public Page<Computer> findAllByGpu(String gpu, Pageable pageable);
    @RestResource(path = "byHdd")
    public Page<Computer> findAllByHdd(String hdd, Pageable pageable);

    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Integer id);

}
