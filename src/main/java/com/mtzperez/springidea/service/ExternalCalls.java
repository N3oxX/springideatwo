package com.mtzperez.springidea.service;

import com.mtzperez.springidea.model.dto.CarDto;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.List;

@FeignClient(name="springidea")
@RequestMapping("cars")
public interface ExternalCalls {

    public List<CarDto> getAll();

    public CarDto create(@Valid @RequestBody CarDto car);
}
