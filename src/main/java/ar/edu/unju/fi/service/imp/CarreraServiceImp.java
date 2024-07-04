package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapDTO;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService{
	
	@Autowired
	CarreraRepository carreraRepository;	
	
	@Autowired
	CarreraMapDTO carreraMapDto;
	
	@Override
	public void guardarCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
			carreraRepository.save(carrera);
	}

	@Override
	public List<CarreraDTO> mostrarCarreras() {
		// TODO Auto-generated method stub
		
		return carreraMapDto.convertirListaCarreraAListaCarreraDTO(carreraRepository.findCarrerasByEstado(true));
	}

	@Override
	public void borrarCarrera(String codigo) {
		List<Carrera> carreras = carreraRepository.findAll();
		carreras.forEach(carrera -> {
			if(carrera.getCodigo().equals(codigo)) {
				carrera.setEstado(false);
				carreraRepository.save(carrera);
			}
		});
	}

	@Override
	public Carrera buscarCarrera(String codigo) { 
		// TODO Auto-generated method stub
		List<Carrera> todasLasCarreras = carreraRepository.findAll();
		for (Carrera carreras : todasLasCarreras) {
			if(carreras.getCodigo().equals(codigo)) {
				return carreras;
			}
		}
		return null;
	}

	@Override
	public void modificarCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		carreraRepository.save(carrera);
	}

}