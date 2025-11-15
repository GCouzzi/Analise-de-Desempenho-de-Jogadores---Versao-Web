/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsalles.appanalise.gsalles.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author gabri
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "desempenho_criterio_jogo_jogador")
public class DesempenhoCriterioJogoJogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "criterio_id", nullable = false)
    @ManyToOne
    private Criterio criterio;
    @JoinColumn(name = "jogo_jogador_id", nullable = false)
    @ManyToOne
    private JogoJogador jogoJogador;
    @Column(name = "numero_tentativas", nullable = false)
    private int numeroTentativas;
    @Column(name = "numero_acertos", nullable = false)
    private int numeroAcertos;
    @Column(name = "peso", nullable = false)
    private int peso;
    
}
