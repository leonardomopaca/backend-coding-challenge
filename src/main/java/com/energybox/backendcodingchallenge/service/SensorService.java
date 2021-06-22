package com.energybox.backendcodingchallenge.service;

import com.energybox.backendcodingchallenge.domain.Gateway;
import com.energybox.backendcodingchallenge.domain.Sensor;
import com.energybox.backendcodingchallenge.repository.GatewayRepository;
import com.energybox.backendcodingchallenge.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private GatewayRepository gatewayRepository;

    public Iterable<Sensor> getSensors(){
        return sensorRepository.findAll();
    }

    public Optional<Sensor> getSensorById(Long id){
        return sensorRepository.findById(id);
    }

    public Optional<Iterable<Sensor>> getSensorByGateway(Gateway gateway){
        return sensorRepository.getSensorByGateway(gateway);
    }

    public Sensor saveSensor(Sensor sensor){
        return sensorRepository.save(sensor);
    }
}
