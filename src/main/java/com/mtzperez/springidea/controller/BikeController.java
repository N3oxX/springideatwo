package com.mtzperez.springidea.controller;

import com.mtzperez.springidea.model.dto.BikeDto;
import com.mtzperez.springidea.model.dto.CarDto;
import com.mtzperez.springidea.repository.BikeRepository;
import com.mtzperez.springidea.service.BikeService;
import com.mtzperez.springidea.service.CarService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RefreshScope
@RestController
@RequestMapping("bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @Autowired
    private CarService carService;

    @Data
    @AllArgsConstructor
    class Merge{
        List<BikeDto> bikeDtos;
        List<CarDto> carDtos;
    }
    @GetMapping
    public List<BikeDto> getBikes() {
        List<BikeDto> bikes = bikeService.getBikes();
        bikes.addAll(carService.getAll().stream().map(carDto ->  new BikeDto(carDto.getName())).collect(Collectors.toList()));
        return bikes;
    }

    @Value( "${namecar:unknownCar}" )
    private String nameCar;
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BikeDto create(@Valid @RequestBody BikeDto car) {
        car.name = car.name + " " + nameCar;
        return bikeService.createBike(car);
    }
}
