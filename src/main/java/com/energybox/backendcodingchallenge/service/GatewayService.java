package com.energybox.backendcodingchallenge.service;

import com.energybox.backendcodingchallenge.repository.GatewayRepository;
import org.neo4j.annotations.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GatewayService {

    @Autowired
    private GatewayRepository gatewayRepository;


}
