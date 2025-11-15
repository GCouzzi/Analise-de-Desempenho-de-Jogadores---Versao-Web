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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jogos_jogadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JogoJogador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario postadoPor;
    
    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogo;
    
    @ManyToOne
    @JoinColumn(name = "jogador_id", nullable = false)
    private Jogador jogador;
    
    @Column(nullable = false)
    private LocalDate data;
    
    @OneToMany(mappedBy = "jogoJogador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesempenhoCriterioJogoJogador> desempenhoCriterios = new ArrayList<>();
    
    @OneToMany(mappedBy = "jogoJogador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesempenhoCriterioDiretoJogoJogador> desempenhoCriteriosDiretos = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusJogador status;
    
    @Column(name = "cartao_vermelho", nullable = false)
    private boolean cartaoVermelho;
    
    @Column(name = "cartao_amarelo", nullable = false)
    private boolean cartaoAmarelo;
    
    @Column(name = "minutos_jogados", nullable = false)
    private int minutosJogados;
    
    @Column(name = "nota_geral", nullable = false)
    private double notaGeral;
    
    public enum StatusJogador{
        RESERVA, TITULAR
    }
}
