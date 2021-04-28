package br.com.orange.usuario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orange.usuario.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByNomeContainingIgnoreCase(String nameClient);

}
