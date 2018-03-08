package cl.abaadmin.repository.hist.facturaciones;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import cl.abaadmin.entities.hist.facturaciones.FacturadoOperadora;
import cl.abaadmin.vo.reportes.FacturadoDetalleMesOpe;
import cl.abaadmin.vo.reportes.FacturadoPromedio;
import cl.abaadmin.vo.reportes.FacturadoRegionMes;
import cl.abaadmin.vo.reportes.FacturadoRegionOpe;
import cl.abaadmin.vo.reportes.FacturadoVO;

@Transactional("histTransactionManager")
public interface FacturacionRepository extends JpaRepository<FacturadoOperadora, Integer> {
	
	@Query("Select new cl.abaadmin.vo.reportes.FacturadoVO(fo.regionId, fo.nRegion, fo.region, sum(fo.totalPagar)) "
			+ "From FacturadoOperadora fo "
			+ "Where fo.mes >= :mesIni And fo.mes <= :mesFin "
			+ "And fo.anio >= :anioIni And fo.anio <= :anioFin "
			+ "Group By fo.regionId, fo.nRegion, fo.region "
			+ "Order By fo.nRegion asc")
	List<FacturadoVO> findFacturadoRegion(@Param("mesIni") Integer mesIni, 
			@Param("mesFin") Integer mesFin, @Param("anioIni") Integer anioIni,
			@Param("anioFin") Integer anioFin);
	
	@Query("Select new cl.abaadmin.vo.reportes.FacturadoRegionOpe(fo.regionId, fo.region, fo.operadoraId, fo.operadora, sum(fo.totalPagar)) "
			+ "From FacturadoOperadora fo "
			+ "Where fo.regionId = :region And fo.mes >= :mesIni And fo.mes <= :mesFin "
			+ "And fo.anio >= :anioIni And fo.anio <= :anioFin "
			+ "Group By fo.regionId, fo.region, fo.operadoraId, fo.operadora "
			+ "Order By fo.regionId, fo.operadoraId asc")
	List<FacturadoRegionOpe> findFacturadoRegionDetalleOpe(@Param("mesIni") Integer mesIni, 
			@Param("mesFin") Integer mesFin, @Param("anioIni") Integer anioIni,
			@Param("anioFin") Integer anioFin,@Param("region") Integer region);
	
	@Query("Select new cl.abaadmin.vo.reportes.FacturadoRegionMes(fo.regionId, fo.region, fo.anio, fo.mes, sum(fo.totalPagar)) "
			+ "From FacturadoOperadora fo "
			+ "Where fo.regionId = :region And fo.mes >= :mesIni And fo.mes <= :mesFin "
			+ "And fo.anio >= :anioIni And fo.anio <= :anioFin "
			+ "Group By fo.regionId, fo.region, fo.anio, fo.mes "
			+ "Order By fo.regionId, fo.anio, fo.mes asc")
	List<FacturadoRegionMes> findFacturadoRegionDetalleMes(@Param("mesIni") Integer mesIni, 
			@Param("mesFin") Integer mesFin, @Param("anioIni") Integer anioIni,
			@Param("anioFin") Integer anioFin, @Param("region") Integer region);
	
	@Query("Select new cl.abaadmin.vo.reportes.FacturadoDetalleMesOpe(fo.regionId, fo.region, fo.operadoraId, fo.operadora, fo.mes, fo.anio, sum(fo.totalPagar)) "
			+ "From FacturadoOperadora fo Where fo.regionId = :region And "
			+ " fo.mes = :mes And fo.anio = :anio "
			+ "Group By fo.regionId, fo.region, fo.anio, fo.mes, fo.operadoraId, fo.operadora "
			+ "Order By fo.operadoraId asc")
	List<FacturadoDetalleMesOpe> findFacturadoDetalleMes(@Param("mes") Integer mes, 
			@Param("anio") Integer anio, @Param("region") Integer region);
	
	@Query("Select new cl.abaadmin.vo.reportes.FacturadoDetalleMesOpe(fo.regionId, fo.region, fo.operadoraId, fo.operadora, fo.mes, fo.anio, sum(fo.totalPagar)) "
			+ "From FacturadoOperadora fo Where fo.regionId = :region And "
			+ "fo.operadoraId = :operadora And fo.mes >= :mesIni And fo.mes <= :mesFin "
			+ "And fo.anio >= :anioIni And fo.anio <= :anioFin "
			+ "Group By fo.regionId, fo.region, fo.operadoraId, fo.operadora, fo.anio, fo.mes "
			+ "Order By fo.anio, fo.mes asc")
	List<FacturadoDetalleMesOpe> findFacturadoDetalleOpe(@Param("mesIni") Integer mesIni, 
			@Param("mesFin") Integer mesFin, @Param("anioIni") Integer anioIni,
			@Param("anioFin") Integer anioFin, @Param("region") Integer region, @Param("operadora") Integer operadora);
	
	@Query("Select new cl.abaadmin.vo.reportes.FacturadoPromedio(fo.operadoraId, fo.anio, fo.mes, avg(fo.descDispo), avg(fo.descVel), avg(fo.totalPagar)) "
			+ "From FacturadoOperadora fo Group By fo.operadoraId, fo.anio, fo.mes "
			+ "Order By fo.operadoraId, fo.anio, fo.mes asc")
	List<FacturadoPromedio> findFacturadoPromedio();
	
}
