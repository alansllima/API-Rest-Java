package com.concessionaria.apirest.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionaria.apirest.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	Veiculo findById(long id);
}
