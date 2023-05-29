package com.ElvanoSablone.workshop.presentation.controllers;

import com.ElvanoSablone.workshop.persistence.entities.OrderProduct;
import com.ElvanoSablone.workshop.persistence.entities.Working;
import com.ElvanoSablone.workshop.presentation.dto.OrderProductDTO;
import com.ElvanoSablone.workshop.presentation.dto.WorkingDTO;
import com.ElvanoSablone.workshop.services.OrderProductService;
import com.ElvanoSablone.workshop.services.WorkingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workings")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkingController {


    @Autowired
    private WorkingService workingService;

    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public List<WorkingDTO> getWorkings() {
        return workingService.getAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public WorkingDTO getArtistById(@PathVariable long id) {
        return convertToDTO(workingService.getById(id));
    }

    @PostMapping
    public WorkingDTO createWorking(@RequestBody WorkingDTO newWorking) {
        Working working = convertToEntity(newWorking);

        working = workingService.create(working);

        return convertToDTO(working);
    }


    @PutMapping("/{id}")
    public WorkingDTO updateWorking(@PathVariable long id, @RequestBody WorkingDTO updateWorking) {
        Working working = convertToEntity(updateWorking);
        working = workingService.update(id, working);

        return convertToDTO(working);
    }

    @DeleteMapping("/{id}")
    public WorkingDTO deleteWorking(@PathVariable long id) {
        return convertToDTO(workingService.delete(id));
    }

    private WorkingDTO convertToDTO(Working working) {
        return modelMapper.map(working, WorkingDTO.class);
    }

    private Working convertToEntity(WorkingDTO dto) {
        return modelMapper.map(dto, Working.class);
    }

    private OrderProductDTO convertToOrderProductDTO(OrderProduct orderProduct) {
        return modelMapper.map(orderProduct, OrderProductDTO.class);
    }
}
