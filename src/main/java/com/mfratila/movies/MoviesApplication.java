package com.mfratila.movies;

import com.mfratila.movies.models.ApplicationUser;
import com.mfratila.movies.models.Role;
import com.mfratila.movies.repositories.RoleRepository;
import com.mfratila.movies.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MoviesApplication {

    @Value("${MONGO_DATABASE}")
    private String mongoDatabase;

    @Value("${MONGO_USER}")
    private String mongoUser;

    @Value("${MONGO_PASSWORD}")
    private String mongoPassword;

    @Value("${MONGO_CLUSTER}")
    private String mongoCluster;

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            userRepository.deleteAll();
            roleRepository.deleteAll();

            System.out.println("MONGO_DATABASE: " + mongoDatabase);
            System.out.println("MONGO_USER: " + mongoUser);
            System.out.println("MONGO_PASSWORD: " + mongoPassword);
            System.out.println("MONGO_CLUSTER: " + mongoCluster);

            //if(roleRepository.findByAuthority("ADMIN").isPresent()) return;

            Role adminRole = roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            ApplicationUser admin = new ApplicationUser(
                    new ObjectId(),
                    "admin",
                    passwordEncoder.encode("password"),
                    roles
            );
            userRepository.save(admin);
        };
    }

}