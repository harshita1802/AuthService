package dev.harshita.AuthService.security.repository;

import java.util.Optional;

import dev.harshita.AuthService.security.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}
