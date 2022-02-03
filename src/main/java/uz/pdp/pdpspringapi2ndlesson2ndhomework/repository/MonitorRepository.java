package uz.pdp.pdpspringapi2ndlesson2ndhomework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Brand;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Monitor;
@RepositoryRestResource(path = "monitor",collectionResourceRel = "list")
public interface MonitorRepository extends JpaRepository<Monitor,Integer> {
    @RestResource(path = "byBrand")
    public Page<Monitor> findAllByBrand(Brand brand, Pageable pageable);
    @RestResource(path = "byScreenRefreshRate")
    public Page<Monitor> findAllByScreenRefreshRate(String screenRefreshRate, Pageable pageable);
    @RestResource(path = "byCurvedScreen")
    public Page<Monitor> findAllByCurvedScreen(boolean curvedScreen, Pageable pageable);
    @RestResource(path = "byDisplaySize")
    public Page<Monitor> findAllByDisplaySize(double displaySize, Pageable pageable);
    @RestResource(path = "byConnectionType")
    public Page<Monitor> findAllByConnectBy(String connectBy, Pageable pageable);
    @RestResource(path = "byResponseTime")
    public Page<Monitor> findAllByResponseTime(double responseTime, Pageable pageable);



}
