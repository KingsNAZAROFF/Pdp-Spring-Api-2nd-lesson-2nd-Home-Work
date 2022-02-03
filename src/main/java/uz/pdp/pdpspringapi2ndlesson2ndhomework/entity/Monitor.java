package uz.pdp.pdpspringapi2ndlesson2ndhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.template.AbsEntity;

import javax.persistence.*;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Monitor extends AbsEntity {

    private String screenRefreshRate;
    private boolean curvedScreen;
    private double displaySize;
    private String connectBy;
    private double responseTime;


}
