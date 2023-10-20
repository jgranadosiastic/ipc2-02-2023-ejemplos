/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jgranados.app_agular_api.app.servlets.estudiantes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jgranados.app_agular_api.app.db.DBEstudiante;
import com.jgranados.app_agular_api.app.db.Estudiante;
import com.jgranados.app_agular_api.app.exceptions.InvalidDataException;
import com.jgranados.app_agular_api.app.exceptions.NotFoundException;
import com.jgranados.app_agular_api.app.services.estudiantes.StudentService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.http.entity.ContentType;

/**
 *
 * @author jose
 */
@WebServlet(name = "StudentsController", urlPatterns = {"/v1/students"})
public class StudentsController extends HttpServlet {

    // Arquitectura RESTful: stateless, REST : Representational State Transfer
    // REST API
    // RESTful API
    
    // Read = GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("carnet") == null) {
            this.loadList(request, response);
        } else {
            this.loadStudent(request, response, request.getParameter("carnet"));
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Create = POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request);
        System.out.println(request.getContentType());

        //request.getReader().lines().forEach(line -> System.out.println(line));
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        Estudiante estudiante = objectMapper.readValue(request.getInputStream(), Estudiante.class);
        System.out.println("eee" + estudiante);

        response.setContentType(ContentType.APPLICATION_JSON.getMimeType());
        try {
            DBEstudiante dbEstudiante = new DBEstudiante();
            StudentService estudianteServicio = new StudentService(dbEstudiante);
            estudiante = estudianteServicio.createStudent(estudiante);
            objectMapper.writeValue(response.getWriter(), estudiante);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } catch (InvalidDataException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
    
    // Update = PUT
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    // Delete = DELETE
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String carnet = request.getParameter("carnet");
        DBEstudiante dbEstudiante = new DBEstudiante();
        StudentService estudianteServicio = new StudentService(dbEstudiante);
        
        try {
            estudianteServicio.deleteStudent(carnet);
        } catch (NotFoundException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBEstudiante dbEstudiante = new DBEstudiante();
        StudentService estudianteServicio = new StudentService(dbEstudiante);
        
        List<Estudiante> estudiantes = estudianteServicio.getAll();

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.writeValue(response.getWriter(), estudiantes);
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response, String carnet) throws ServletException, IOException {
        DBEstudiante dbEstudiante = new DBEstudiante();
        StudentService estudianteServicio = new StudentService(dbEstudiante);
        
        try {
            Estudiante estudiante = estudianteServicio.getStudentByCarnet(carnet);
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            objectMapper.writeValue(response.getWriter(), estudiante);
        } catch (NotFoundException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
