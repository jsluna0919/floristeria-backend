package co.floristeria.jpa.pedido;

import co.floristeria.jpa.arreglofloral.ArregloFloralEntity;
import co.floristeria.jpa.cliente.ClienteEntity;
import co.floristeria.jpa.destinatario.DestinatarioEntity;
import co.floristeria.model.pedido.EstadoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    private ClienteEntity cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arreglo_floral_id", referencedColumnName = "id",nullable = false)
    private ArregloFloralEntity arregloFloral;

    @ManyToOne
    @JoinColumn(name = "destinatario_id", referencedColumnName = "id", nullable = false)
    private DestinatarioEntity destinatario;

    private String fechaEntrega;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @CreatedDate
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
}
