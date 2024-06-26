package br.com.fiap.springpfentregas.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_VIAGEM")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VIAGEM")
    @SequenceGenerator(name = "SQ_VIAGEM", sequenceName = "SQ_VIAGEM", allocationSize = 1)
    @Column(name = "ID_VIAGEM")
    private Long id;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_VIAGEM_PRODUTO",
            joinColumns = {
                    @JoinColumn(
                            name = "TB_VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(
                                    name = "FK_VIAGEM_PRODUTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "TB_PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_PRODUTO_VIAGEM"
                            )
                    )
            }
    )
    private Set<Produto> produtos = new LinkedHashSet<>();

    private LocalDateTime saida ;
    private LocalDateTime chegada ;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_VIAGEM_PASSAGEIRO",
            joinColumns = {
                    @JoinColumn(
                            name = "TB_VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(
                                    name = "FK_VIAGEM_PASSAGEIRO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "TB_PASSAGEIRO",
                            referencedColumnName = "ID_PASSAGEIRO",
                            foreignKey = @ForeignKey(
                                    name = "FK_PASSAGEIRO_VIAGEM"
                            )
                    )
            }
    )

    private Set<Passageiro> passageiros = new LinkedHashSet<>();


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TB_PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_PESSOA_VIAGEM"
            )
    )

    private Pessoa cliente;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TB_ENDERECO_DESTINO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_DESTINO_VIAGEM"
            )
    )

    private Endereco destino;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TB_ENDERECO_ORIGEM",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_ORIGEM_VIAGEM"
            )
    )
    private Endereco origem;





}
