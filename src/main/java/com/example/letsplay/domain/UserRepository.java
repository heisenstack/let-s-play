package com.example.letsplay.domain;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsername(String username);
    User save(User user);
    Optional<User> findByUsername(String username);
}
