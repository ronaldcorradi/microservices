package br.com.orange.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orange.usuario.entities.Endereco;


public interface EnderecoRepository extends JpaRepository<Endereco,Long>{

}
