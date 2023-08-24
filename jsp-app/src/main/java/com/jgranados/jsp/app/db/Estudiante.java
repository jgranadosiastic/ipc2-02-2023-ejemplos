/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.db;

import java.time.LocalDate;

/**
 *
 * @author jose
 * POJO
 * Plain Old Java Object
 */
public class Estudiante {
    private String carnet;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Estudiante(String carnet, String nombre, String apellidos, String fechaNacimiento) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = LocalDate.now();
    }
    
    public Estudiante(String carnet, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
