package com.example.demo2.repository;
import java.util.Optional;
import com.example.demo2.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{ 'email' : { $regex: ?0, $options: 'i' } }") // Case-insensitive email search
    Optional<User> findByEmail(String email);
}
