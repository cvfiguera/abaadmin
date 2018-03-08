package cl.abaadmin.repository.control.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import cl.abaadmin.entities.control.security.Role;

@Transactional("controlTransactionManager")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query("select max(roleId) from Role")
	public Integer getMaxId();

}
