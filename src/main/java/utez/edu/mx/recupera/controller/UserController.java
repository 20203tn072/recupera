package utez.edu.mx.recupera.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.recupera.model.dto.UserDto;
import utez.edu.mx.recupera.model.entity.UserBean;
import utez.edu.mx.recupera.service.impl.UserImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserImpl personService;


    //crear usuario
    @PostMapping("/person")
    public UserDto create(@RequestBody UserDto userDto){
        UserBean personSave = personService.save(userDto);
        return userDto.builder()
                .id(personSave.getIdperson())
                .username(personSave.getUsuario())
                .password(personSave.getContra())
                .status(personSave.getStatus())
                .build();
    }

    //actualizar ususario
    @PutMapping("/person")
    public UserDto update(@RequestBody UserDto userDto){
        UserBean personUpdate = personService.save(userDto);
        return userDto.builder()
                .id(personUpdate.getIdperson())
                .username(personUpdate.getUsuario())
                .password(personUpdate.getContra())
                .status(personUpdate.getStatus())
                .build();
    }

    //borrar ususario
    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            UserBean person = personService.findById(id);
            personService.delete(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (DataAccessException ex){
            response.put("mensaje", ex.getMessage());
            response.put("Person", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //buscar por ID
    @GetMapping("/person/{id}")
    public UserBean showById(@PathVariable Long id){
        try{
            return personService.findById(id);
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }
    }

    //mostrar todos los ususarios
    @GetMapping("/person")
    public List<UserBean> findAll(){
        try{
            return personService.findAll();
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en la base de datos: ", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }

    }
}
