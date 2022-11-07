package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.model.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.model.repository.FlorRepository;

@Service
public class FlorService {
	
	@Autowired
	private FlorRepository fr;
    @Autowired
    private ModelMapper modelMapper;
	
	public List <FlorDTO> getAllFlors(){
		
		List <Flor> flors=new ArrayList<Flor>();
		fr.findAll().forEach(f->flors.add(f));
		List<FlorDTO> florsDTO=new ArrayList<FlorDTO>();
		if(!flors.isEmpty()) {
			
			flors.forEach(f->florsDTO.add(modelMapper.map(f, FlorDTO.class)));
		}
		
		return florsDTO;
	}
	
	public FlorDTO getFlorById(int id) {
		
		Flor flor=fr.findById(id).get();
		FlorDTO florDTO=modelMapper.map(flor, FlorDTO.class);
		
		return florDTO;
	}
	
	public void saveOrUpdate(FlorDTO florDTO) {
		
		Flor flor=modelMapper.map(florDTO, Flor.class);
		
		fr.save(flor);
	}
	
	public void delete(int id) {
		
		fr.deleteById(id);
	}

}
