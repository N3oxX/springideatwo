package com.mtzperez.springidea.service;

import com.mtzperez.springidea.model.dto.BikeDto;

import com.mtzperez.springidea.model.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "springidea")
public interface CarService {
    @GetMapping("cars")
    List<CarDto> getAll();

    @PostMapping("cars")
    BikeDto create(@Valid @RequestBody CarDto car);
}
