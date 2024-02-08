package utez.edu.mx.recupera.service;


import utez.edu.mx.recupera.model.dto.UserDto;
import utez.edu.mx.recupera.model.entity.UserBean;

import java.util.List;

public interface IUser {

    UserBean save(UserDto userDto);

    UserBean findById(Long id);

    void delete(UserBean userBean);

    List<UserBean> findAll();

}
