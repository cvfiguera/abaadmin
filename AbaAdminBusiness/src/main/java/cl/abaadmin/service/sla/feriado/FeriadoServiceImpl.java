package cl.abaadmin.service.sla.feriado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.sla.sla.Feriado;
import cl.abaadmin.repository.sla.sla.FeriadoRepository;
import cl.abaadmin.vo.FeriadoVO;

@Service
public class FeriadoServiceImpl implements FeriadoService {

	@Autowired
	private FeriadoRepository feriadoRepository;
	
	@Override
	public List<FeriadoVO> getFeriados() {
		List<Feriado> feriados = feriadoRepository.findAll();
		List<FeriadoVO> feriadosVO = new ArrayList<FeriadoVO>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i<feriados.size(); i++) {
			Feriado feriado = feriados.get(i);
			feriadosVO.add(new FeriadoVO(feriado.getFeriadoId(), sdf.format(feriado.getFecha()),
					feriado.getMotivo()));
		}
		return feriadosVO;
	}

	@Override
	public List<FeriadoVO> getFeriadoByMes(Integer mes, Integer anio) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy"); 
		calendar.set(Calendar.YEAR, anio);
		calendar.set(Calendar.MONTH, mes -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date fechaIni = calendar.getTime();
		calendar.set(Calendar.MONTH, mes);
		calendar.add(Calendar.DATE, -1);  
		Date fechaFin = calendar.getTime();
		List<Feriado> feriados = feriadoRepository.getFeriadosByMes(fechaIni, fechaFin);
		List<FeriadoVO> feriadosVO = new ArrayList<FeriadoVO>();
		
		for(Feriado feriado : feriados) {
			feriadosVO.add(new FeriadoVO(feriado.getFeriadoId(), dt.format(feriado.getFecha()), feriado.getMotivo()));
		}
		return feriadosVO;
	}

	@Override
	public FeriadoVO getFeriado(Integer feriadoId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Feriado feriado = feriadoRepository.findOne(feriadoId);
				
		return new FeriadoVO(feriado.getFeriadoId(), sdf.format(feriado.getFecha()), feriado.getMotivo());
	}

	@Override
	public FeriadoVO saveFeriado(FeriadoVO feriado) {

		Feriado feriadoNew;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if (feriado.getId()!=null) {
			feriadoNew = feriadoRepository.findOne(feriado.getId());
			try {
				feriadoNew.setFecha(feriado.getStart()==null?null:sdf.parse(feriado.getStart()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			feriadoNew.setMotivo(feriado.getTitle());
			feriadoRepository.save(feriadoNew);
		}
		else {
			try {
				feriadoNew = new Feriado();
				feriadoNew.setFecha(feriado.getStart()==null?null:sdf.parse(feriado.getStart()));
				feriadoNew.setMotivo(feriado.getTitle());
				feriadoNew = feriadoRepository.save(feriadoNew);
				feriado.setId(feriadoNew.getFeriadoId());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}		
		return feriado;
	}

	@Override
	public FeriadoVO deleteFeriado(Integer feriadoId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Feriado feriado = feriadoRepository.findOne(feriadoId);
		feriadoRepository.delete(feriado);
		
		return new FeriadoVO(feriado.getFeriadoId(), sdf.format(feriado.getFecha()), feriado.getMotivo());

	}
}
