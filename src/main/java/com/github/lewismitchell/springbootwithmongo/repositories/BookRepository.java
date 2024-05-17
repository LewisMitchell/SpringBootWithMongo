package com.github.lewismitchell.springbootwithmongo.repositories;

import com.github.lewismitchell.springbootwithmongo.models.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;

//<BookModel, String> states that this 'repository' stores BookModel and that the ID is a String
public interface BookRepository extends MongoRepository<BookModel, String> {

}
