package mood.green.springframeworkmongodocker.dao;

import mood.green.springframeworkmongodocker.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book,Integer> {

}