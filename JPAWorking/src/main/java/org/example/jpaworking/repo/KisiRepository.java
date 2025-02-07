package org.example.jpaworking.repo;

import org.example.jpaworking.entity.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KisiRepository extends JpaRepository<Kisi, Long> {
}
