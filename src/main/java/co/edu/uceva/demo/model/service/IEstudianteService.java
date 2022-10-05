package co.edu.uceva.demo.model.service;

import co.edu.uceva.demo.model.entities.Estudiante;

import java.util.List;

public interface IEstudianteService {
    List<Estudiante> listar();
    Estudiante findById(Long id);
    void crear(Estudiante estudiante);
    void delete(Estudiante estudiante);
}
