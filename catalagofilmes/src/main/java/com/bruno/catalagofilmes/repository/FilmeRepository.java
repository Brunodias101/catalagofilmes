package com.bruno.catalagofilmes.repository;

import com.bruno.catalagofilmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
