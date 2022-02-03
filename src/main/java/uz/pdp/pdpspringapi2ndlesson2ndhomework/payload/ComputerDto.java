package uz.pdp.pdpspringapi2ndlesson2ndhomework.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {
    @NotNull(message = "field lar bo'sh bo'lmasligi kerak ! ! !")
    private String name;
    @NotNull(message = "field lar bo'sh bo'lmasligi kerak ! ! !")
    private String motherBoard;
    @NotNull(message = "field lar bo'sh bo'lmasligi kerak ! ! !")
    private String ram;
    @NotNull(message = "field lar bo'sh bo'lmasligi kerak ! ! !")
    private String cpu;
    private String ssd;
    private String gpu;
    private String hdd;
    private byte[] bytes;

}
