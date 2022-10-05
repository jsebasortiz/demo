package co.edu.uceva.demo.model.dao;

import co.edu.uceva.demo.model.entities.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface IEstudianteDao extends CrudRepository<Estudiante, Long> {
}
