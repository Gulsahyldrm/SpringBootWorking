package org.example.jpaworking.repo;

import org.example.jpaworking.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresRepository extends JpaRepository<Adres,Long> {
}
