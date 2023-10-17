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
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import javax.json.JsonObject;
import org.apache.http.entity.ContentType;

/**
 *
 * @author jose
 */
@WebServlet(name = "StudentsController", urlPatterns = {"/v1/students"})
public class StudentsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            estudiante = dbEstudiante.crearEstudiante(estudiante);
            objectMapper.writeValue(response.getWriter(), estudiante);
        } catch (InvalidDataException e) {
            
        }

    }
}
