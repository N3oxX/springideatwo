package com.mtzperez.springidea.service;

import com.mtzperez.springidea.model.dto.BikeDto;
import com.mtzperez.springidea.model.entity.Bike;
import com.mtzperez.springidea.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<BikeDto> getBikes() {
        return bikeRepository.findAll().stream().map(bike -> new BikeDto(bike.getName())).collect(Collectors.toList());
    }

    public BikeDto createBike(BikeDto bikeDto) {
        Bike bike = new Bike(bikeDto.name);
        bikeRepository.save(bike);
        return new BikeDto(bike.getName());
    }
}
