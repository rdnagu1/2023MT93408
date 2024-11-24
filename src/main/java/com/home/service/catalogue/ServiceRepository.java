package com.home.service.catalogue;

import com.home.service.catalogue.model.Service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<Service, String> {

	List<Service> findAll();
}
