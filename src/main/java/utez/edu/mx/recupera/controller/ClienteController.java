package utez.edu.mx.recupera.controller;


import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.recupera.model.dto.ClienteDto;
import utez.edu.mx.recupera.model.entity.ClienteBean;
import utez.edu.mx.recupera.service.impl.ClienteImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ClienteController {

    private final ClienteImpl clienteService;

    //crear cliente
    @PostMapping("/client")
    public ClienteDto create(@RequestBody ClienteDto clienteDto){
        ClienteBean clienteSave = clienteService.save(clienteDto);
        return clienteDto.builder()
                .id(clienteSave.getIdperson())
                .name(clienteSave.getName())
                .surname(clienteSave.getSurname())
                .lastname(clienteSave.getLastname())
                .address(clienteSave.getAddress())
                .phone(clienteSave.getPhone())
                .build();
    }

    //actualizar cliente
    @PutMapping("/client")
    public ClienteDto update(@RequestBody ClienteDto clienteDto){
        ClienteBean clienteSave = clienteService.save(clienteDto);
        return clienteDto.builder()
                .id(clienteSave.getIdperson())
                .name(clienteSave.getName())
                .surname(clienteSave.getSurname())
                .lastname(clienteSave.getLastname())
                .address(clienteSave.getAddress())
                .phone(clienteSave.getPhone())
                .build();
    }

    //borrar cliente
    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            ClienteBean person = clienteService.findById(id);
            clienteService.delete(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (DataAccessException ex){
            response.put("mensaje", ex.getMessage());
            response.put("Person", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //buscar cliente por ID
    @GetMapping("/client/{id}")
    public ClienteBean showById(@PathVariable Long id){
        try{
            return clienteService.findById(id);
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }
    }

    //obetener todos los clientes
    @GetMapping("/client")
    public List<ClienteBean> findAll(){
        try{
            return clienteService.findAll();
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en la base de datos: ", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }

    }

}
