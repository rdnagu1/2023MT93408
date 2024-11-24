package com.home.service.catalogue;

import com.home.service.catalogue.model.Service;
import com.home.service.catalogue.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCatalogueService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> getServiceById(String id) {
        return serviceRepository.findById(id);
    }

    public Service addService(Service service) {
        return serviceRepository.save(service);
    }

    public Service updateService(String id, Service service) {
        if (serviceRepository.existsById(id)) {
            service.setId(id);
            return serviceRepository.save(service);
        }
        return null;
    }

    public boolean deleteService(String id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
