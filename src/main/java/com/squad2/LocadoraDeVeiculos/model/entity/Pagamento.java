
import com.squad2.LocadoraDeVeiculos.model.entity.Carrinho;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@ToString(exclude = {"numeroCartao", "codigoSeguranca"})
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pagamento")
public class Pagamento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal custoTotal;

    @Column(length = 16, nullable = false)
    @NotNull
    @Size(max = 16)
    private String numeroCartao;

    @Column(length = 4, nullable = false)
    @NotNull
    @Size(max = 4)
    private String codigoSeguranca;

    @Column(nullable = false)
    @NotNull
    private String nomeCartao;

    @Column(nullable = false)
    @NotNull
    private String metodoPagamento;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;
}