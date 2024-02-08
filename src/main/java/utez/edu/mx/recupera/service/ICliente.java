package utez.edu.mx.recupera.service;

import utez.edu.mx.recupera.model.dto.ClienteDto;
import utez.edu.mx.recupera.model.entity.ClienteBean;

import java.util.List;

public interface ICliente {

    ClienteBean save(ClienteDto clienteDto);

    ClienteBean findById(Long id);

    void delete(ClienteBean clienteBean);

    List<ClienteBean> findAll();
}
