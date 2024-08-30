package in.bushansirgur.springboot.crudapi.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "apolice_seguro")
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_franquia", nullable = false)
    private BigDecimal valorFranquia;

    @Column(name = "protecao_terceiro", nullable = false)
    private Boolean protecaoTerceiro;

    @Column(name = "protecao_causas_naturais", nullable = false)
    private Boolean protecaoCausasNaturais;

    @Column(name = "protecao_roubo", nullable = false)
    private Boolean protecaoRoubo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(BigDecimal valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public Boolean getProtecaoTerceiro() {
        return protecaoTerceiro;
    }

    public void setProtecaoTerceiro(Boolean protecaoTerceiro) {
        this.protecaoTerceiro = protecaoTerceiro;
    }

    public Boolean getProtecaoCausasNaturais() {
        return protecaoCausasNaturais;
    }

    public void setProtecaoCausasNaturais(Boolean protecaoCausasNaturais) {
        this.protecaoCausasNaturais = protecaoCausasNaturais;
    }

    public Boolean getProtecaoRoubo() {
        return protecaoRoubo;
    }

    public void setProtecaoRoubo(Boolean protecaoRoubo) {
        this.protecaoRoubo = protecaoRoubo;
    }
}
