package com.agendador.usuario.infrastructure.repository;


import com.agendador.usuario.infrastructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
