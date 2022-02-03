package uz.pdp.pdpspringapi2ndlesson2ndhomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.payload.ApiResponse;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.payload.ComputerDto;
import uz.pdp.pdpspringapi2ndlesson2ndhomework.service.ComputerService;

import javax.validation.Valid;

@RestController
@RequestMapping("computer")
public class ComputerController {

    @Autowired
    ComputerService computerService;
    @PostMapping
    public ResponseEntity<?> addComputer(@Valid  @RequestBody ComputerDto computerDto, MultipartHttpServletRequest request){
        ApiResponse apiResponse = computerService.addComputer(computerDto, request);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editComputer(@PathVariable Integer id,@Valid @RequestBody ComputerDto computerDto,MultipartHttpServletRequest request){
        ApiResponse response = computerService.editComputer(id, computerDto, request);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }
}
