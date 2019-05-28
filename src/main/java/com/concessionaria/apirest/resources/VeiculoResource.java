package com.concessionaria.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concessionaria.apirest.models.Veiculo;
import com.concessionaria.apirest.repository.VeiculoRepository;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value="/api")
@Api(value ="API REST Concessionaria")
@CrossOrigin(origins = "*")
public class VeiculoResource {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@GetMapping("/veiculos")

	public List<Veiculo> listaVeiculos(){
		return veiculoRepository.findAll();
		
	}
	
	@GetMapping("/veiculos/{id_veiculo}")
	
	public Veiculo procurarVeiculo(@PathVariable(value="id_veiculo") long id){
		return veiculoRepository.findById(id);		
	}	
	@PostMapping("/veiculos")

	public Veiculo novoVeiculo(@RequestBody Veiculo veiculo ){
		return veiculoRepository.save(veiculo);
	}	
	@DeleteMapping("/veiculos")
	
	public void deletaVeiculo(@RequestBody Veiculo veiculo ){
		veiculoRepository.delete(veiculo);
		
	}	
	@PutMapping("/veiculos")

	public void alteraVeiculo(@RequestBody Veiculo veiculo ){
		veiculoRepository.save(veiculo);
		
	}	
}
