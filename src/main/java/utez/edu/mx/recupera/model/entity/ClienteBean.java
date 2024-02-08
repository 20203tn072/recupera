package utez.edu.mx.recupera.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class ClienteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson")
    private Long idperson;
    @Column(name = "nombre")
    private String name;
    @Column(name = "primApellido")
    private String surname;
    @Column(name = "segApellido")
    private String lastname;
    @Column(name = "direccion")
    private String address;
    @Column(name = "telefono")
    private String phone;
}

