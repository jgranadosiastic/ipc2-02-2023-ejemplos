/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.app_agular_api.app.services.estudiantes;

import com.jgranados.app_agular_api.app.db.DBEstudiante;
import com.jgranados.app_agular_api.app.db.Estudiante;
import com.jgranados.app_agular_api.app.exceptions.InvalidDataException;
import com.jgranados.app_agular_api.app.exceptions.NotFoundException;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jose
 */
public class StudentService {
    DBEstudiante dbStudente;
    
    public StudentService(DBEstudiante dbEstudiante) {
        this.dbStudente = dbEstudiante;
    }
    
    public Estudiante createStudent(Estudiante estudiante)  throws InvalidDataException {
        validate(estudiante);
        
        return dbStudente.crearEstudiante(estudiante);
    }
    
    public Estudiante getStudentByCarnet(String carnet) throws NotFoundException {
        Optional<Estudiante> studentOpt = dbStudente.getStudentByCarnet(carnet);
        return studentOpt.orElseThrow(() -> new NotFoundException("Estudiante Not found"));
    }
    
    public List<Estudiante> getAll() {
        return dbStudente.getAll();
    }
    
    public boolean deleteStudent(String carnet)  throws NotFoundException {
        Optional<Estudiante> studentOpt = dbStudente.getStudentByCarnet(carnet);
        if (!studentOpt.isPresent()) {
            throw new NotFoundException("Estudiante Not found");
        }
        dbStudente.deleteStudent(carnet);
        return true;
    }
    private void validate(Estudiante estudiante) throws InvalidDataException {
        if (StringUtils.isEmpty(estudiante.getCarnet()) ||
                StringUtils.isBlank(estudiante.getCarnet())) {
            throw new InvalidDataException("El carnet del estudiante es requerido.");
        }

        if (estudiante.getCarnet().length() > 10) {
            throw new InvalidDataException("El carnet no debe de tener mas de 10 caracteres.");
        }
    }
}
