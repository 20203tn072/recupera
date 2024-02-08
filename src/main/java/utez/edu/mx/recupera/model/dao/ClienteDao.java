package utez.edu.mx.recupera.model.dao;

import org.springframework.data.repository.CrudRepository;
import utez.edu.mx.recupera.model.entity.ClienteBean;
import utez.edu.mx.recupera.model.entity.UserBean;

import java.util.Optional;

public interface ClienteDao extends CrudRepository<ClienteBean, Long> {

    Optional<ClienteBean> findById(Long id);
}
