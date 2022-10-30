package com.example.prkt5upseva.Repository;
import com.example.prkt5upseva.Models.Password;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<Password, Long> {
    Password findByPasswordName(String passwordName);
}