package uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.AttachmentContent;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Brand;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Brand brand;

    private String name;

    @OneToOne
    private AttachmentContent attachmentContent;
}
