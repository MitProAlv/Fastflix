package br.com.fastflix.project.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.fastflix.project.domain.Login;
import br.com.fastflix.project.repository.LoginRepository;

@RestController
@CrossOrigin

public class LoginResource {

	LoginRepository loginRepository;

	@RequestMapping(value = "/funciona", method = RequestMethod.GET)
	public ResponseEntity<?> Email() {

		return ResponseEntity.status(HttpStatus.OK).body("Ta funcionando!");
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> novoLogin(@RequestBody Login login) {

		
		
		loginRepository.save(login);
		return ResponseEntity.status(HttpStatus.CREATED).body(login);
		
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<?> obterLogin() {

		List<Login> login = loginRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(login);
	}

}
