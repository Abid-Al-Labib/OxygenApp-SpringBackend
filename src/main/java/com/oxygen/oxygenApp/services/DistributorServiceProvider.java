package com.oxygen.oxygenApp.services;

import com.oxygen.oxygenApp.entities.Booth;
import com.oxygen.oxygenApp.entities.Distributor;
import com.oxygen.oxygenApp.entities.Order;
import com.oxygen.oxygenApp.repository.BoothRepository;
import com.oxygen.oxygenApp.repository.DistributorRepository;
import com.oxygen.oxygenApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class DistributorServiceProvider implements DistributorService{

    @Autowired
    DistributorRepository distributorRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BoothRepository boothRepository;


    @Autowired
    OrderService orderService;
    @Autowired
    BoothService boothService;


    public String addDistributor(String name, Integer emptyLarge, Integer emptySmall, Integer fullLarge, Integer fullSmall)
    {
        try
        {
            Distributor newDistributor = new Distributor(name, emptyLarge, fullLarge, emptySmall, fullSmall);
            distributorRepository.save(newDistributor);
            return "Distributor Added";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    public String addDistributor(Distributor distributor)
    {
        try
        {
            distributorRepository.save(distributor);
            return "Distributor Added";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    public String placeOrder(String type,String size, String boothName, Integer quantity, String dateString, Integer distributorId)
    {
        Distributor distributor;
        Optional<Distributor> val = distributorRepository.findById(distributorId);
        if(val.isPresent())
        {
            distributor = val.get();
        }
        else
        {
            return "Distributor does not exist";
        }

//        Date date = null;
//        try {
//            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
//        } catch (ParseException e) {
//            return e.getMessage();
//        }

        Order order = orderService.createOrderForDistributor(
                distributor,
                boothName,
                quantity,
                dateString,
                type,
                size);

        Booth booth = boothService.getBoothByName(boothName);

        if(booth == null )
        {
            return "booth was not found";
        }
        else if(order==null)
        {
            return "order could not be created";
        }
        else
        {



            if(type.compareTo("Send") == 0)
            {
                Integer currentStock = 0;
                System.out.println("in send");
                if(size.compareTo("Large") == 0)
                {
                    System.out.println("in large");
                    System.out.println("before: " + distributor);
                    currentStock = booth.getLargeCylinderStock();
                    currentStock += quantity;
                    booth.setLargeCylinderStock(currentStock);

                    currentStock = distributor.getFullCylindersLarge();
                    currentStock -= quantity;
                    distributor.setFullCylindersLarge(currentStock);

                    System.out.println("after: " + distributor);
                }
                if(size.compareTo("Small") == 0)
                {
                    currentStock = booth.getSmallCylinderStock();
                    currentStock += quantity;
                    booth.setSmallCylinderStock(currentStock);

                    currentStock = distributor.getFullCylindersSmall();
                    currentStock -= quantity;
                    distributor.setFullCylindersSmall(currentStock);
                }


            }
            else if(type.compareTo("Receive") == 0)
            {

                Integer currentStock = 0;

                if(size.compareTo("Large") == 0)
                {
                    currentStock = booth.getLargeCylinderStock();
                    currentStock -= quantity;
                    booth.setLargeCylinderStock(currentStock);

                    currentStock = distributor.getEmptyCylindersLarge();
                    currentStock += quantity;
                    distributor.setEmptyCylindersLarge(currentStock);
                }

                if(size.compareTo("Small") == 0)
                {
                    currentStock = booth.getSmallCylinderStock();
                    currentStock -= quantity;
                    booth.setSmallCylinderStock(currentStock);

                    currentStock = distributor.getEmptyCylindersSmall();
                    currentStock += quantity;
                    distributor.setEmptyCylindersSmall(currentStock);
                }


            }
            else if(type.compareTo("Refill") == 0)
            {

                Integer currentStock = 0;

                if(size.compareTo("Large") == 0)
                {
                    currentStock = booth.getLargeCylinderStock();
                    currentStock += quantity;
                    booth.setLargeCylinderStock(currentStock);

                    currentStock = distributor.getEmptyCylindersLarge();
                    currentStock -= quantity;
                    distributor.setEmptyCylindersLarge(currentStock);
                }
                if(size.compareTo("Small") == 0)
                {
                    currentStock = booth.getSmallCylinderStock();
                    currentStock += quantity;
                    booth.setSmallCylinderStock(currentStock);

                    currentStock = distributor.getEmptyCylindersSmall();
                    currentStock -= quantity;
                    distributor.setEmptyCylindersSmall(currentStock);
                }


            }
            else if(type.compareTo("Restock") == 0)
            {

                Integer currentStock = 0;

                if(size.compareTo("Large") == 0)
                {
                    currentStock = booth.getLargeCylinderStock();
                    currentStock -= quantity;
                    booth.setLargeCylinderStock(currentStock);

                    currentStock = distributor.getFullCylindersLarge();
                    currentStock += quantity;
                    distributor.setFullCylindersLarge(currentStock);
                }
                if(size.compareTo("Small") == 0)
                {
                    currentStock = booth.getSmallCylinderStock();
                    currentStock -= quantity;
                    booth.setSmallCylinderStock(currentStock);

                    currentStock = distributor.getFullCylindersSmall();
                    currentStock += quantity;
                    distributor.setFullCylindersSmall(currentStock);
                }


            }
            else
            {
                return "Invalid type";
            }

            distributor.addOrder(order);
            //distributorRepository.save(distributor);


                System.out.println("in try");
                System.out.println(distributor);
                distributorRepository.save(distributor);
                boothRepository.save(booth);
                return "Transaction Complete";


        }

    }


    public String removeDistributor(Integer distributorId)
    {
        try
        {
            distributorRepository.deleteById(distributorId);
            return "Distributor deleted";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @Override
    public List<Distributor> getAllDistributor() {
        try
        {
            List<Distributor> distributors= distributorRepository.findAll();
            distributors.size();
            return distributors;
        }
        catch (Exception e)
        {
            return null;
        }
    }


}
