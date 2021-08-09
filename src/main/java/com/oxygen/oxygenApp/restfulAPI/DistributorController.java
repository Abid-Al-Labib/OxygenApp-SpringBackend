package com.oxygen.oxygenApp.restfulAPI;

import com.oxygen.oxygenApp.entities.Distributor;
import com.oxygen.oxygenApp.repository.DistributorRepository;
import com.oxygen.oxygenApp.services.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/",
                        "http://localhost:3000/add-distributor"})
@RestController
@RequestMapping("/distributor")
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    //get all disitributors
    @GetMapping("/all")
    public List<Distributor> getAllDistributors()
    {

        return distributorService.getAllDistributor();
    }


    //place order
    @PutMapping("/placeOrder")
    public String placeOrder(
            @RequestParam(name = "type") String type,
            @RequestParam(name = "size") String size,
            @RequestParam(name = "boothName") String boothName,
            @RequestParam(name = "quantity") Integer quantity,
            @RequestParam(name = "date") String dateString,
            @RequestParam(name = "dis_id") Integer distributorId
                             )
    {
       return distributorService.placeOrder(
               type,
               size,
               boothName,
               quantity,
               dateString,
               distributorId
       );
    }

    //add distributor
    @PostMapping("/addDistributor")
    public String addNewDistributor(@RequestParam(name = "name")String name,
                                    @RequestParam(name = "emptyCylindersLarge")Integer ecl,
                                    @RequestParam(name = "fullCylindersLarge")Integer fcl,
                                    @RequestParam(name = "emptyCylindersSmall")Integer ecs,
                                    @RequestParam(name = "fullCylindersSmall")Integer fcs)
    {
        System.out.println(name+" "+ecl+" "+fcl+" "+ecs+" "+fcs);
        return distributorService.addDistributor(name,ecl,ecs,fcl,fcs);
    }


    //remove distributor
    @DeleteMapping("/deleteDistributor")
    public String deleteDistributor(@RequestParam(name = "id") Integer distributorId)
    {
        return distributorService.removeDistributor(distributorId);
    }



}
