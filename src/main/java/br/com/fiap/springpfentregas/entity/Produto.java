package br.com.fiap.springpfentregas.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", allocationSize = 1)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name= "ET_PRODUTO")
    private String etiqueta;

    @Column(name= "NM_PRODUTO")
    private String nome;

    @Column(name= "PS_PRODUTO")
    private Float peso;

    @Column(name = "LG_PRODUTO")
    private Float largura;

    @Column(name = "AT_PRODUTO")
    private Float altura;

    @Column(name = "PF_PRODUTO")
    private Float profundidade;
}
