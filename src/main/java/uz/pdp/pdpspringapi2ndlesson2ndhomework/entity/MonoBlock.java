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
public class MonoBlock extends AbsEntity {

    @Column(nullable = false)
    private String ram;

    @Column(nullable = false)
    private String cpu;
    @Column(nullable = false)
    private double displaySize;

    private String ssd;
    private String hdd;
}
