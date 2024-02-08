package utez.edu.mx.recupera.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.recupera.model.dao.ClienteDao;
import utez.edu.mx.recupera.model.dto.ClienteDto;
import utez.edu.mx.recupera.model.entity.ClienteBean;
import utez.edu.mx.recupera.service.ICliente;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteImpl implements ICliente {

    private final ClienteDao clienteDao;

    //guardar clientes
    @Transactional
    @Override
    public ClienteBean save(ClienteDto clienteDto){
        ClienteBean cliente = ClienteBean.builder()
                .idperson(clienteDto.getId())
                .name(clienteDto.getName())
                .surname(clienteDto.getSurname())
                .lastname(clienteDto.getLastname())
                .address(clienteDto.getAddress())
                .phone(clienteDto.getPhone())
                .build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public ClienteBean findById(Long id){
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(ClienteBean clienteBean){
        clienteDao.delete(clienteBean);
    }

    @Transactional
    @Override
    public List<ClienteBean> findAll(){
        return (List< ClienteBean>) clienteDao.findAll();
    }
}
