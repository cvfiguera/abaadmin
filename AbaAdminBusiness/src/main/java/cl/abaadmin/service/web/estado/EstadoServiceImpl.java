package cl.abaadmin.service.web.estado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.EstadoAdjudicacion;
import cl.abaadmin.entities.web.web.EstadoConexion;
import cl.abaadmin.entities.web.web.EstadoMineduc;
import cl.abaadmin.repository.web.web.EstadoAdjudicacionRepository;
import cl.abaadmin.repository.web.web.EstadoConexionRepository;
import cl.abaadmin.repository.web.web.EstadoMineducRepository;
import cl.abaadmin.vo.EstadoVO;
import cl.abaadmin.vo.SubEstadoVO;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired private EstadoAdjudicacionRepository eAjudicacionRepository;
	@Autowired private EstadoConexionRepository eConexionRepository;
	@Autowired private EstadoMineducRepository eMineducRepository;
	
	
	@Override
	public List<EstadoVO> getEstados(Integer tipo) {
		
		List<? extends Object> estados;
		if (tipo == 1) {
			List<EstadoAdjudicacion> estadosAdj = eAjudicacionRepository.findEstados();
			List<EstadoVO> estadosAdjVO = new ArrayList<EstadoVO>();
			for(int i=0; i<estadosAdj.size(); i++) {
				EstadoAdjudicacion estado = estadosAdj.get(i);
				estadosAdjVO.add(new EstadoVO(estado.getEstadoId(), estado.getDescripcion()));
			}
			estados = estadosAdjVO;
		} else if (tipo == 2) {
			estados = eConexionRepository.findAll();
		} else {
			estados = eMineducRepository.findAll();
		}
		
		return (List<EstadoVO>) estados;
	}

	@Override
	public EstadoVO getEstado(Integer tipo, Integer estadoId) {
		
		Object estado;
		if (tipo == 1) {
			estado = eAjudicacionRepository.findAll();
		} else if (tipo == 2) {
			estado = eConexionRepository.findAll();
		} else {
			estado = eMineducRepository.findAll();
		}
		
		return (EstadoVO) estado;
	}

	@Override
	public EstadoVO saveEstado(Integer tipo, EstadoVO estado) {
		
		if (tipo == 1) {
			EstadoAdjudicacion estadoAdj = eAjudicacionRepository.save(new EstadoAdjudicacion(estado.getEstadoId(), 
					null, estado.getDescripcion()));
			estadoAdj.setPadre(estadoAdj);
			EstadoAdjudicacion estadoNew = eAjudicacionRepository.save(estadoAdj);
			estado.setEstadoId(estadoNew.getEstadoId());
		} else if (tipo == 2) {
			EstadoConexion estadoNew = new EstadoConexion();
			if (estado.getEstadoId()!= null)
				estadoNew.setEstadoId(estado.getEstadoId());
			estadoNew.setDescripcion(estado.getDescripcion());
			estadoNew = eConexionRepository.save(estadoNew);
			estado.setEstadoId(estadoNew.getEstadoId());
		} else {
			EstadoMineduc estadoNew = new EstadoMineduc();
			if (estado.getEstadoId()!= null)
				estadoNew.setEstadoId(estado.getEstadoId());
			estadoNew.setDescripcion(estado.getDescripcion());
			estadoNew = eMineducRepository.save(estadoNew);
			estado.setEstadoId(estadoNew.getEstadoId());
		}
		
		return estado;
	}

	@Override
	public Boolean deleteEstado(Integer tipo, Integer estadoId) {
		
		if (tipo == 1 || tipo == 4) {
			EstadoAdjudicacion estado = eAjudicacionRepository.findOne(estadoId);
			try {
				eAjudicacionRepository.delete(estado);
			} catch (Exception ex) {
				return false;
			}
		} else if (tipo == 2) {
			EstadoConexion estado = eConexionRepository.findOne(estadoId);
			try {
				eConexionRepository.delete(estado);
			} catch (Exception ex) {
				return false;
			}
		} else {
			EstadoMineduc estado = eMineducRepository.findOne(estadoId);
			try {
				eMineducRepository.delete(estado);
			} catch (Exception ex) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<SubEstadoVO> getSubEstados() {
		
		List<EstadoAdjudicacion> subEstados = eAjudicacionRepository.findAll();
		List<SubEstadoVO> subEstadosVO = new ArrayList<SubEstadoVO>();
		for(int i=0; i<subEstados.size(); i++) {
			EstadoAdjudicacion estado = subEstados.get(i);
			subEstadosVO.add(new SubEstadoVO(estado.getEstadoId(), new EstadoVO(estado.getPadre().getEstadoId(), 
					estado.getPadre().getDescripcion()), estado.getDescripcion()));
		}
		return subEstadosVO;
	}

	@Override
	public SubEstadoVO saveSubEstado(SubEstadoVO subestado) {
		
		EstadoAdjudicacion subestadoNew = new EstadoAdjudicacion();
		
		if(subestado.getEstadoId()!=null)
			subestadoNew.setEstadoId(subestado.getEstadoId());
		
		subestadoNew.setPadre(eAjudicacionRepository.findOne(subestado.getPadre().getEstadoId()));
		subestadoNew.setDescripcion(subestado.getDescripcion());
		
		subestadoNew = eAjudicacionRepository.save(subestadoNew);
		
		subestado.setEstadoId(subestadoNew.getEstadoId());
		
		return subestado;
	}
}
