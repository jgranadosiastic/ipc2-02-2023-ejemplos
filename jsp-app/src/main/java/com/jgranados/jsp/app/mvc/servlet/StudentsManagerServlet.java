/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jgranados.jsp.app.mvc.servlet;

import com.jgranados.jsp.app.db.DBEstudiante;
import com.jgranados.jsp.app.db.Estudiante;
import com.jgranados.jsp.app.exceptions.InvalidDataException;
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

/**
 *
 * @author jose
 */
@WebServlet(name = "StudentsManagerServlet", urlPatterns = {"/mvc/student-servlet"})
public class StudentsManagerServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Estudiante estudiante = new Estudiante(request.getParameter("carnet"),
                request.getParameter("nombre"),
                request.getParameter("apellidos"),
                request.getParameter("fechaNacimiento"));

        try {
            DBEstudiante dbEstudiante = new DBEstudiante();
            estudiante = dbEstudiante.crearEstudiante(estudiante);
            request.setAttribute("estudiante", estudiante);

            //Forward
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher(this.getServletContext().getContextPath() + "/students/post-action-mvc.jsp");
            dispatcher.forward(request, response);
        } catch (InvalidDataException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            //Forward
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher(this.getServletContext().getContextPath() + "/students/post-action-mvc.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void loadList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBEstudiante dbEstudiante = new DBEstudiante();
        List<Estudiante> estudiantes = dbEstudiante.getAll();

        request.setAttribute("estudiantes", estudiantes);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/students/list.jsp");
        dispatcher.forward(request, response);
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response, String carnet) throws ServletException, IOException {
        DBEstudiante dbEstudiante = new DBEstudiante();
        Optional<Estudiante> studentOpt = dbEstudiante.getStudentByCarnet(carnet);
        request.setAttribute("estudianteOpt", studentOpt);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/students/details.jsp");
        dispatcher.forward(request, response);
    }
}
