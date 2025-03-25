package com.agendador.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telefone")
@Builder
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
