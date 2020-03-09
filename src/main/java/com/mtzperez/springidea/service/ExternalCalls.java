package com.mtzperez.springidea.service;

import com.mtzperez.springidea.model.dto.CarDto;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import java.util.List;

@FeignClient(name="springidea")

public interface ExternalCalls {

    @GetMapping("/cars")
    public List<CarDto> getAll();

    @PostMapping("/cars")
    public CarDto create(@Valid @RequestBody CarDto car);
}
