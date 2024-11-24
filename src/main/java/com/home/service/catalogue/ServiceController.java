package com.home.service.catalogue;

import com.home.service.catalogue.model.Service;
import com.home.service.catalogue.service.ServiceCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceCatalogueService serviceCatalogueService;

    @GetMapping
    public List<Service> getAllServices() {
        return serviceCatalogueService.getAllServices();
    }

    @GetMapping("/{id}")
    public Optional<Service> getServiceById(@PathVariable String id) {
        return serviceCatalogueService.getServiceById(id);
    }

    @PostMapping
    public Service addService(@RequestBody Service service) {
        return serviceCatalogueService.addService(service);
    }

    @PutMapping("/{id}")
    public Service updateService(@PathVariable String id, @RequestBody Service service) {
        return serviceCatalogueService.updateService(id, service);
    }

    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable String id) {
        if (serviceCatalogueService.deleteService(id)) {
            return "Service deleted successfully!";
        } else {
            return "Service not found!";
        }
    }
}
