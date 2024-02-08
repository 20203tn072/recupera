package utez.edu.mx.recupera.model.dao;

import org.springframework.data.repository.CrudRepository;
import utez.edu.mx.recupera.model.entity.UserBean;

import java.util.Optional;

public interface UserDao extends CrudRepository<UserBean, Long> {

    Optional<UserBean> findById(Long id);
}
