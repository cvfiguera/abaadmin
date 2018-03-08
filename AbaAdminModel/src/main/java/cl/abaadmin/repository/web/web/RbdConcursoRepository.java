package cl.abaadmin.repository.web.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.web.RbdConcurso;

@Transactional("webTransactionManager")
public interface RbdConcursoRepository extends JpaRepository<RbdConcurso, Integer> {
	
	RbdConcurso findByRbdRbdIdAndConcursoConcursoId(Integer rbdId, Integer concursoId);

}
