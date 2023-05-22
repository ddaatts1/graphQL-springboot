package com.GraphQL.GraphQL.Repository;

import com.GraphQL.GraphQL.Model.Address;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, ObjectId> {
}
