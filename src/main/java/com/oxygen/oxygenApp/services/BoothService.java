package com.oxygen.oxygenApp.services;

import com.oxygen.oxygenApp.entities.Booth;

import java.util.List;

public interface BoothService {

    String addBooth(String location,String name, String manager, String phone, Integer largeCylinderStock, Integer smallCylinderStock,String type);
    String removeBoothById(Integer id);
    String removeBoothByName(String name);
    List<Booth> getBoothsByType(String type);
    List<Booth> getAllBooths();
    Booth getBoothByName(String name);

}
