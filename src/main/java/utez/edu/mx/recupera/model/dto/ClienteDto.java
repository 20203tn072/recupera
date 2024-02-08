package utez.edu.mx.recupera.model.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private String address;
    private String phone;

}
