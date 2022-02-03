package uz.pdp.pdpspringapi2ndlesson2ndhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String motherBoard;

    @Column(nullable = false)
    private String ram;

    @Column(nullable = false)
    private String cpu;

    private String ssd;
    private String gpu;
    private String hdd;
    @OneToOne
    private AttachmentContent attachmentContent;
}
