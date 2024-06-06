package org.example.controller;

import org.example.core.dto.LabWorkDTO;
import org.example.core.dto.LabWorkDTOBuilder;
import org.example.service.api.IAllLabService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AllLabController {
    private final IAllLabService allLabService;

    public AllLabController(IAllLabService allLabService) {
        this.allLabService = allLabService;
    }

    @GetMapping("/all")
    public List<LabWorkDTO> getAllLabs() {
        List<LabWorkDTO> labWorkDTOS = allLabService.findAll()
                .stream()
                .map((f) -> new LabWorkDTOBuilder()
                        .setLabworkId(f.getLabwork().getId())
                        .setName(f.getLabwork().getName())
                        .setGrade(f.getGrade())
                        .setPassed(f.isPassed())
                        .build())
                .collect(Collectors.toList());

        return labWorkDTOS;
    }

    @PostMapping("/closing")
    public void labClosing(@RequestParam(name = "labList") String labList,
                           @RequestParam(name = "labNumber") String labNumber,
                           @RequestParam(name = "inputField") String inputField) {

        System.out.println("Lab List: " + labList);
        System.out.println("Lab Number: " + labNumber);
        System.out.println("Input Field: " + inputField);
    }
}
