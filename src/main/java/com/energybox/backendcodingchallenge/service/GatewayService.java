package com.energybox.backendcodingchallenge.service;

import com.energybox.backendcodingchallenge.domain.Gateway;
import com.energybox.backendcodingchallenge.domain.Sensor;
import com.energybox.backendcodingchallenge.repository.GatewayRepository;
import com.energybox.backendcodingchallenge.repository.SensorRepository;
import org.neo4j.annotations.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class GatewayService {

    @Autowired
    private GatewayRepository gatewayRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public Iterable<Gateway> getGateways() {
        return gatewayRepository.findAll();
    }

    public Gateway saveGateway(Gateway gateway){
        return gatewayRepository.save(gateway);
    }

    //TODO User story: When a gateway is deleted, all the sensors of this gateway should be deleted (OR update the info to gateway = null??)
    public Gateway deleteGateway(Long id){
        Optional<Gateway> gateway = gatewayRepository.findById(id);
        gatewayRepository.deleteById(id);
        List<Optional<Sensor>> sensors = sensorRepository.getSensorByGateway(gateway.get());
        //TODO LOOP TO DELETE OR UPDATE EACH SENSOR RELATED TO THE GATEWAY
        sensors.stream().forEach(sensor -> {sensorRepository.deleteById(sensor.ge9);});

        return gateway.get();

    }



}
