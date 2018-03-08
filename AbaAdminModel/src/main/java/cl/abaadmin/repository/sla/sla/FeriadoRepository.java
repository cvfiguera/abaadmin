package cl.abaadmin.repository.sla.sla;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.sla.sla.Feriado;

@Transactional("slaTransactionManager")
public interface FeriadoRepository extends JpaRepository<Feriado, Integer>{

	public List<Feriado> findByFecha(Date fecha);
	
	@Query("select max(feriadoId) from Feriado")
	public Integer getMaxId();
	
	@Query("from Feriado f where f.fecha >= :fechaIni and f.fecha <= :fechaFin")
	public List<Feriado> getFeriadosByMes(@Param("fechaIni") Date fechaIni, @Param("fechaFin") Date fechaFin);
}
