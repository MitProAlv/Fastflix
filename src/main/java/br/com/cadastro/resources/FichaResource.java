package br.com.cadastro.resources;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.cadastro.domain.Ficha;
import br.com.cadastro.repository.FichaRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FichaResource {

	@Bean
	CorsConfigurationSource corsConfigurationSource() 
	{
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins(Arrays.asList("https://git.heroku.com/spring-boot-java-fastflix.git"));
			configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
			configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
                "Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin",
                "Cache-Control", "Content-Type"));
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
	}
	
	@Autowired
	FichaRepository fichaRepository;	

		@RequestMapping(value = "/funciona", method = RequestMethod.GET)
		public ResponseEntity<?> funciona() {

			return ResponseEntity.status(HttpStatus.OK).body("Ta funcionando!");
		}
		
		@ResponseBody
		@RequestMapping(value = "/fichas", method = RequestMethod.POST)
		public ResponseEntity<?> novaFicha(@RequestBody Ficha ficha) {
			Optional<Ficha> optFicha = fichaRepository.findById(ficha.getCpf());
			if (optFicha.isPresent()) 
				return ResponseEntity.status(HttpStatus.CONFLICT).body(""); 
			
			fichaRepository.save(ficha);
			return ResponseEntity.status(HttpStatus.CREATED).body(ficha);
		}

		@RequestMapping(value = "/fichas/{customerID}", method = RequestMethod.GET)
		public ResponseEntity<?> obterFichaID(@PathVariable Long customerID) {
			Optional<Ficha> optFicha = fichaRepository.findById(customerID);
			if (optFicha.isPresent()) {
				return ResponseEntity.status(HttpStatus.OK).body(optFicha.get());
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

		@RequestMapping(value = "/fichas/{customerID}", method = RequestMethod.DELETE)
		public ResponseEntity<?> eliminarFichasID(@PathVariable Long customerID) {
			Optional<Ficha> optFicha = fichaRepository.findById(customerID);
			if (!optFicha.isPresent()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
			fichaRepository.deleteById(customerID);
			return ResponseEntity.status(HttpStatus.OK).body(optFicha.get());
		}

		
		@ResponseBody
		@RequestMapping(value = "/fichas/{customerID}", method = RequestMethod.PUT)
		public ResponseEntity<?> alterarFicha(@PathVariable Long cpf, @RequestBody Ficha fichaNova, @RequestBody Ficha ficha) {
			Optional<Ficha> optFicha = fichaRepository.findById(cpf);
			if (!optFicha.isPresent())
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

			Ficha fichaCorrente = optFicha.get();
			if (fichaNova.getCpf() != null && fichaNova.getCpf().intValue() > 0) {
				fichaCorrente.setCpf(fichaNova.getCpf());
			}
		
			if (fichaNova.getNome() != null && fichaNova.getNome().length() > 0) {
				fichaCorrente.setNome(fichaNova.getNome());
			}
			if (fichaNova.getEmail() != null && fichaNova.getEmail().length() > 0) {
				fichaCorrente.setEmail(fichaNova.getEmail());
			}
			if (fichaNova.getCep() != null && fichaNova.getCep().length() > 0) {
				fichaCorrente.setCep(fichaNova.getCep());
			}
			if (fichaNova.getCelular() != null && fichaNova.getCelular().length() > 0) {
				fichaCorrente.setCelular(fichaNova.getCelular());
			}
			if (fichaNova.getPais() != null && fichaNova.getPais().length() > 0) {
				fichaCorrente.setPais(fichaNova.getPais());
			}
			if (fichaNova.getCidade() != null && fichaNova.getCidade().length() > 0) {
				fichaCorrente.setCidade(fichaNova.getCidade());
			}
			if (fichaNova.getSenha() != null && fichaNova.getSenha().length() > 0) {
				fichaCorrente.setSenha(fichaNova.getSenha());
			}
			if (fichaNova.getLogradouro() != null && fichaNova.getLogradouro().length() > 0) {
				fichaCorrente.setLogradouro(fichaNova.getLogradouro());
			}
			
			if (fichaNova.getNcasa() != null && fichaNova.getNcasa().length() > 0) {
				fichaCorrente.setNcasa(fichaNova.getNcasa());
			}
			
			if (fichaNova.getDtcadastro() != null && fichaNova.getDtcadastro().length() > 0) {
				fichaCorrente.setDtcadastro(fichaNova.getDtcadastro());
			}
			if (fichaNova.getDtnascimento() != null && fichaNova.getDtnascimento().length() > 0) {
				fichaCorrente.setDtnascimento(fichaNova.getDtnascimento());
			}
			
			fichaRepository.save(fichaCorrente);
			return ResponseEntity.status(HttpStatus.OK).body(fichaCorrente);
		}

		@RequestMapping(value = "/fichas", method = RequestMethod.GET)
		public ResponseEntity<?> obterFichas() {
			List<Ficha> fichas = fichaRepository.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(fichas);
		}
		
}
