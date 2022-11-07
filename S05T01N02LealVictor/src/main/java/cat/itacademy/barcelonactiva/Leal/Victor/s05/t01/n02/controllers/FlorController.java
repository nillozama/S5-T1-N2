package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.model.services.FlorService;

//Notación para indicar que es un controlador de tipo Rest
@RestController
//Notación para indicar el contexto de nuestros endpoint es decir /flor/nombreServicio
@RequestMapping("/flor")
//URL que permitimos que consuman nuestras APIS
//En caso de querer permitir todos los origentes ponemos en lugar de la URL un *
@CrossOrigin(origins = "http://localhost:4200")
public class FlorController {

	/*
	 * El nombre de las flores es único, en la creación y actualizacón se hace la
	 * validación
	 */

	// Inyección de dependencias
	@Autowired
	private FlorService florService;

	// Se le indica el tipo de petición asi como el nombre del servicio
	@GetMapping("/getAll")
	public ResponseEntity<List<FlorDTO>> getAllFlors(@RequestParam(required = false) String title) {
		
		ResponseEntity<List<FlorDTO>>responseEntity;
		
		try {
			List<FlorDTO> florsDTO = new ArrayList<FlorDTO>();

			florsDTO = florService.getAllFlors();

			if (florsDTO.isEmpty()) {
				responseEntity= new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				
				responseEntity= new ResponseEntity<List<FlorDTO>>(florsDTO, HttpStatus.OK);
			}

		} catch (Exception e) {
			responseEntity= new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<FlorDTO> getFlor(@PathVariable("id") int id) {
		
		ResponseEntity <FlorDTO> responseEntity;
		FlorDTO florDTO = florService.getFlorById(id);

	    if (florDTO!=null) {
	    	responseEntity= new ResponseEntity<>(florDTO, HttpStatus.OK);
	      } else {
	    	  responseEntity= new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
		
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFlor(@PathVariable("id") int id) {
		
		ResponseEntity <HttpStatus> responseEntity;
		
	    try {
	        florService.delete(id);
	        responseEntity=new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        responseEntity=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	    
	    return responseEntity;
	}

	@PostMapping("/add")
	public ResponseEntity<FlorDTO> addFlor(@RequestBody FlorDTO florDTO) {
		
		ResponseEntity <FlorDTO> responseEntity;
		
	    try {
	        florService.saveOrUpdate(florDTO);
	        responseEntity= new ResponseEntity<>(florDTO, HttpStatus.CREATED);
	      }catch (Exception e) {
	    	responseEntity=new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	    
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<FlorDTO> updateFlor(@RequestBody FlorDTO florDTO) {
		
		ResponseEntity <FlorDTO> responseEntity;
		
		if(florService.getFlorById(florDTO.getPk_FlorID())!=null) {
			
			florService.saveOrUpdate(florDTO);
			
			responseEntity=new ResponseEntity<>(florDTO, HttpStatus.OK);
		}
		else {
			
			responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
