package br.com.fastflix.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fastflix.project.domain.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
