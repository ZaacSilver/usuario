package com.agendador.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", length = 10)
    private String numero;

    @Column(name = "ddd", length = 3)
    private String ddd;

    @ManyToOne // Relacionamento ManyToOne com a entidade Usuario
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") // Mapeia a chave estrangeira
    private Usuario usuario; // Relacionamento com Usuario
}
