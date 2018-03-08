package cl.abaadmin.repository.control.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import cl.abaadmin.entities.control.security.User;

@Transactional("controlTransactionManager")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select max(userId) from User")
	public Integer getMaxId();
	
	User findOneByUsername(String username);
	
	List<User> findByRoleRoleId(Integer rolId);
}
