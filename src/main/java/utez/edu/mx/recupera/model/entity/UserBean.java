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
@Table(name = "person")
public class UserBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson")
    private Long idperson;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contraseña")
    private String contra;
    @Column(name = "status")
    private Boolean status;

}
