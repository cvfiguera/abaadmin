package cl.abaadmin.repository.web.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.security.Role;

@Transactional("webTransactionManager")
public interface RoleWebRepository extends JpaRepository<Role, Integer> {
	
	@Query("select max(roleId) from Role")
	public Integer getMaxId();

}
