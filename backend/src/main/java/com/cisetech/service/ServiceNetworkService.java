package com.cisetech.service;

import com.cisetech.entity.ServiceNetwork;
import com.cisetech.repository.ServiceNetworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceNetworkService {

    private final ServiceNetworkRepository serviceNetworkRepository;

    public List<ServiceNetwork> getAllServiceNetworks() {
        return serviceNetworkRepository.findByIsActiveTrueOrderBySortOrderAsc();
    }

    public List<ServiceNetwork> getAllServiceNetworksWithHeadquartersFirst() {
        return serviceNetworkRepository.findByIsActiveTrueOrderByIsHeadquartersDescSortOrderAsc();
    }

    public Optional<ServiceNetwork> getServiceNetworkById(Long id) {
        return serviceNetworkRepository.findById(id);
    }

    @Transactional
    public ServiceNetwork createServiceNetwork(ServiceNetwork serviceNetwork) {
        return serviceNetworkRepository.save(serviceNetwork);
    }

    @Transactional
    public ServiceNetwork updateServiceNetwork(Long id, ServiceNetwork serviceNetworkDetails) {
        return serviceNetworkRepository.findById(id).map(network -> {
            network.setCity(serviceNetworkDetails.getCity());
            network.setRegion(serviceNetworkDetails.getRegion());
            network.setAddress(serviceNetworkDetails.getAddress());
            network.setPhone(serviceNetworkDetails.getPhone());
            network.setLatitude(serviceNetworkDetails.getLatitude());
            network.setLongitude(serviceNetworkDetails.getLongitude());
            network.setIsHeadquarters(serviceNetworkDetails.getIsHeadquarters());
            network.setSortOrder(serviceNetworkDetails.getSortOrder());
            network.setIsActive(serviceNetworkDetails.getIsActive());
            return serviceNetworkRepository.save(network);
        }).orElse(null);
    }

    @Transactional
    public void deleteServiceNetwork(Long id) {
        serviceNetworkRepository.deleteById(id);
    }
}
