package com.oxygen.oxygenApp.services;

import com.oxygen.oxygenApp.entities.Distributor;
import com.oxygen.oxygenApp.repository.DistributorRepository;

import java.util.List;

public interface DistributorService{

    String addDistributor(String name, Integer emptyLarge, Integer emptySmall, Integer fullLarge, Integer fullSmall);
    String addDistributor(Distributor distributor);
    String placeOrder(String type,String size, String boothName, Integer quantity, String dateString, Integer distributorId);
    String removeDistributor(Integer distributorId);
    List<Distributor> getAllDistributor();

}
