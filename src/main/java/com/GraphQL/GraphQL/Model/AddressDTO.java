package com.GraphQL.GraphQL.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private String id;
    private String city;
    private String district;

    public AddressDTO(Address address){
        this.id = address.get_id().toString();
        this.city = address.getCity();
        this.district = address.getDistrict();
    }
}
