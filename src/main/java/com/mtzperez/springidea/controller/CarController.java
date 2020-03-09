package com.mtzperez.springidea.controller;

import com.mtzperez.springidea.model.dto.CarDto;
import com.mtzperez.springidea.service.CarService;
import com.mtzperez.springidea.service.ExternalCalls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("bikes")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private ExternalCalls externalCalls;


    @GetMapping
    public List<CarDto> getAll() {
        return externalCalls.getAll();
    }

    @Value( "${namecar:unknownCar}" )
    private String nameCar;
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CarDto create(@Valid @RequestBody CarDto car) {
        car.name = car.name + " " + nameCar;
        return carService.createCar(car);
    }
}
