package co.edu.uceva.demo.model.entities;

import co.edu.uceva.demo.model.service.IEstudianteService;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;


import java.io.Serializable;
@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GenericGenerator(
            name="estudianteSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name", value = "ESTUDIANTE_SEQ"),
                    @Parameter(name="initial_value", value = "10"),
                    @Parameter(name="increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "estudianteSequenceGenerator")
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private String apellido;
    private Long cedula;

    @Column(name = "creado_en")
    @Temporal(TemporalType.DATE)
    private Date creadoEn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

}
