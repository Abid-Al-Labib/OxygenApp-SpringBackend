package com.oxygen.oxygenApp.restfulAPI;

import com.oxygen.oxygenApp.entities.Booth;
import com.oxygen.oxygenApp.services.BoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/","http://localhost:3000/add-booth"})
@RestController
@RequestMapping("/booth")
public class BoothController {

    @Autowired
    BoothService boothService;


    //get all booth
    @GetMapping("/all")
    public List<Booth> getAllBooth()
    {
        return boothService.getAllBooths();
    }


    //get booths by type
    @GetMapping("/boothsByType")
    public List<Booth> getBoothsByType(@RequestParam(name = "type") String type)
    {
        return boothService.getBoothsByType(type);
    }


    @PostMapping("/addBooth")
    public String addNewBooth(@RequestParam(name = "location") String location,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "manager") String manager,
                              @RequestParam(name = "phone") String phone,
                              @RequestParam(name = "largeCylinderStock") Integer lcs,
                              @RequestParam(name = "smallCylinderStock") Integer scs,
                              @RequestParam(name = "type") String type)

    {
        return boothService.addBooth(location,name,manager,phone,lcs,scs,type);
    }

    @DeleteMapping("/removeBooth")
    public String removeBooth(@RequestParam(name = "id") Integer boothId)
    {
        return boothService.removeBoothById(boothId);
    }
}
