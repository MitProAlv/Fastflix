package br.com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.domain.Ficha;

public interface FichaRepository extends JpaRepository<Ficha, Long> {

}
