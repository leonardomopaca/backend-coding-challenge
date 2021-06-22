package com.energybox.backendcodingchallenge.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Map;

@NodeEntity
public class Sensor {

    @Id
    @GeneratedValue
    private Long id;

    private Map type;

    @Relationship(type = "CONNECTED_TO", direction = Relationship.INCOMING)
    private Gateway gateway;

}
