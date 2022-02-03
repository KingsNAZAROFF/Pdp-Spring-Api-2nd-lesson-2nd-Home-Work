package uz.pdp.pdpspringapi2ndlesson2ndhomework.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.AttachmentContent;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.entity.Computer;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.payload.ApiResponse;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.payload.ComputerDto;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.repository.AttachmentContentRepository;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.repository.ComputerRepository;

import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @SneakyThrows
    public ApiResponse addComputer(ComputerDto computerDto, MultipartHttpServletRequest request)  {
        boolean exists = computerRepository.existsByName(computerDto.getName());
        if (exists){
            return new ApiResponse("Bunday nomli kompyuter mavjud",false);
        }
        Computer computer = new Computer();
        computer.setName(computerDto.getName());
        computer.setMotherBoard(computerDto.getMotherBoard());
        computer.setCpu(computerDto.getCpu());
        computer.setRam(computerDto.getRam());
        computer.setSsd(computerDto.getSsd());
        computer.setHdd(computerDto.getHdd());
        computer.setGpu(computerDto.getGpu());
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setName(file.getOriginalFilename());
        AttachmentContent saved = attachmentContentRepository.save(attachmentContent);
        computer.setAttachmentContent(saved);
        computerRepository.save(computer);
        return new ApiResponse("Computer Db ga saqlandi",true);

    }
    @SneakyThrows
    public ApiResponse editComputer(Integer id,ComputerDto computerDto,MultipartHttpServletRequest request){
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        if (optionalComputer.isEmpty()){
            return new ApiResponse("Bunday kompyuter mavjud emas",false);
        }
        boolean exists = computerRepository.existsByNameAndIdNot(computerDto.getName(), id);
        if (exists){
            return new ApiResponse("Bunday nomli kompyuter mavjud",false);
        }
        Computer computer = optionalComputer.get();
        computer.setName(computerDto.getName());
        computer.setMotherBoard(computerDto.getMotherBoard());
        computer.setCpu(computerDto.getCpu());
        computer.setRam(computerDto.getRam());
        computer.setSsd(computerDto.getSsd());
        computer.setHdd(computerDto.getHdd());
        computer.setGpu(computerDto.getGpu());

        if (request!=null) {
            Iterator<String> fileNames = request.getFileNames();
            MultipartFile file = request.getFile(fileNames.next());
            AttachmentContent attachmentContent = computer.getAttachmentContent();
            attachmentContent.setBytes(file.getBytes());
            attachmentContent.setName(file.getOriginalFilename());
            AttachmentContent saved = attachmentContentRepository.save(attachmentContent);
            computer.setAttachmentContent(saved);
        }
        computerRepository.save(computer);
        return new ApiResponse("Computer Db ga saqlandi",true);

    }
}
