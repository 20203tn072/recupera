package utez.edu.mx.recupera.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.recupera.model.dao.UserDao;
import utez.edu.mx.recupera.model.dto.UserDto;
import utez.edu.mx.recupera.model.entity.UserBean;
import utez.edu.mx.recupera.service.IUser;

import java.security.SecureRandom;
import java.util.List;

@AllArgsConstructor
@Service
public class UserImpl implements IUser {

    private final UserDao userDao;

    //guradar ususarios
    @Transactional
    @Override
    public UserBean save(UserDto userDto){
        boolean status = true;
        UserBean person = UserBean.builder()
                .idperson(userDto.getId())
                .usuario(userDto.getUsername())
                .contra(generarContra(userDto))
                .status(status)
                .build();
        return userDao.save(person);
    }

    @Transactional(readOnly = true)
    @Override
    public UserBean findById(Long id){
        return userDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(UserBean userBean){
        userDao.delete(userBean);
    }

    @Transactional
    @Override
    public List<UserBean> findAll(){
        return (List<UserBean>) userDao.findAll();
    }



    //Crear contraseña
    public String generarContra(UserDto userDto){

        String letterMin = "abcdefghijklmnopqrstuvwxyz";
        String letterMayu = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num = "0123456789";
        String caracEspe = "!@#$%^&*()-_=+[{]};:'\",<.>/?";
        String caracteres = letterMin + letterMayu + num + caracEspe;
        int longitudContra = 8;
        SecureRandom random = new SecureRandom();
        StringBuilder contra = new StringBuilder();
        for (int i = 0; i < longitudContra; i++) {
            int index = random.nextInt(caracteres.length());
            contra.append(caracteres.charAt(index));
        }

        return contra.toString();
    }

}
