package com.GraphQL.GraphQL.Controller;

import com.GraphQL.GraphQL.Model.Address;
import com.GraphQL.GraphQL.Model.AddressDTO;
import com.GraphQL.GraphQL.Repository.AddressRepository;
import com.GraphQL.GraphQL.Repository.MongoRepository;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    MongoRepository mongoRepository;

    @GetMapping("/")
    public List<Address> index(){
        return addressRepository.findAll();
    }

    @QueryMapping
    public List<Document> findAllAddress(){

        List<Document> list = mongoRepository.getAllAddress();
        return list;
    }

    @MutationMapping
    public Address editAddress(@Argument String id, @Argument String newCity) {
        System.out.println("======> " + id);
        Address address = addressRepository.findById(new ObjectId(id)).orElse(null);

        if (address != null) {
            address.setCity(newCity);
            Address updatedAddress = addressRepository.save(address);
            return updatedAddress;
        } else {
            // Handle the case where the address with the given id doesn't exist
            // Return an error message or throw an exception, depending on your requirements
        }

        return null;
    }

    @SubscriptionMapping
    public List<Address> getAllAddressFlux(){
        List<Address> list = addressRepository.findAll();
        return list;
    }



}
