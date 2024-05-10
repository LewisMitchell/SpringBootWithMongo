package com.github.lewismitchell.springbootwithmongo.repositories;

import com.github.lewismitchell.springbootwithmongo.models.SampleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//<SampleModel, String> states that this 'repository' stores SampleModel and that the ID is a String
public interface SampleDataRepository extends MongoRepository<SampleModel, String> {

    List<SampleModel> findByName(String name);
    List<SampleModel> findByDescription(String description);
}
