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
public class Printer extends AbsEntity {



    private String type;
    private boolean colorful;
    private String format;
    private double speedPerMinute;
    private String typeOfPrinting;
    private String connectionType;
}
