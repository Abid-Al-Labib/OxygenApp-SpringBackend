package com.oxygen.oxygenApp.services;

import com.oxygen.oxygenApp.entities.Booth;
import com.oxygen.oxygenApp.repository.BoothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BoothServiceProvider implements BoothService {

    @Autowired
    BoothRepository boothRepository;


    public String addBooth(String location,String name, String manager, String phone, Integer largeCylinderStock, Integer smallCylinderStock, String type)
    {
        Booth newBooth = new Booth(location,name,manager,phone,largeCylinderStock,smallCylinderStock,type);
        try{
            boothRepository.save(newBooth);
            return "New booth added";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }


    public String removeBoothById(Integer id)
    {

        try{
            boothRepository.deleteById(id);
            return "Booth has been deleted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }

    }


    public String removeBoothByName(String name)
    {

        try{
            boothRepository.deleteBoothByName(name);
            return "Booth has been deleted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }

    }

    public List<Booth> getBoothsByType(String type)
    {

        try{
            List<Booth> booths = boothRepository.findBoothsByType(type);
            return booths;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }


    public List<Booth> getAllBooths()
    {
        try{
            List<Booth> booths = boothRepository.findAll();
            return booths;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Booth getBoothByName(String name) {

        try{
            Optional<Booth> booth = boothRepository.findBoothByName(name);
            if(booth.isPresent())
            {
                return booth.get();
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
