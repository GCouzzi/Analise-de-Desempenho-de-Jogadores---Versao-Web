/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsalles.appanalise.gsalles.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author gabri
 */
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "idade", nullable = false)
    private int idade;
    @Column(name = "posicao", nullable = false)
    private String posicao;
    @Column(name = "altura", nullable = false)
    private int altura;
    @Enumerated(EnumType.STRING)
    @Column(name = "perna_dominante", nullable = false)
    private PernaDominante pernaDominante;
            
    public enum PernaDominante{
        DIREITA, ESQUERDA, AMBIDESTRO
    }
}
