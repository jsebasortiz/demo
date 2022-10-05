package co.edu.uceva.demo.controller;

import co.edu.uceva.demo.model.entities.Estudiante;
import co.edu.uceva.demo.model.service.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/estudianteservice")
public class EstudianteRestController {

    @Autowired
    EstudianteServiceImpl estudianteService;

    @GetMapping("/estudiantes")
    public List<Estudiante> listar(){
        return estudianteService.listar();
    }

    @GetMapping("/estudiantes/{id}")
    // public Estudiante buscar(@PathVariable Long id){
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Estudiante estudiante = null;
        try {
            estudiante = estudianteService.findById(id);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error consultando la BD");
            response.put("Error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (estudiante == null){
            response.put("Mensaje", "El estudiante no existe o no está en la BD");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
        return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
    }



    //POSTMAN
    @PostMapping("/estudiantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        this.estudianteService.crear(estudiante);
        return estudiante;
    }

    @PutMapping("/estudiantes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante update(@RequestBody Estudiante estudiante, @PathVariable Long id){
        Estudiante estudianteActual = this.estudianteService.findById(id);
        estudianteActual.setNombre(estudiante.getNombre());
        estudianteActual.setApellido(estudiante.getApellido());
        estudianteActual.setCedula(estudiante.getCedula());
        this.estudianteService.crear(estudianteActual);
        return estudianteActual;
    }

    @DeleteMapping("/estudiantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        Estudiante estudianteActual = this.estudianteService.findById(id);
        this.estudianteService.delete(estudianteActual);
    }
}
