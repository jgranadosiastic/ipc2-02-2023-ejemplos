/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.app_agular_api.app.servlets.files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.entity.ContentType;

/**
 *
 * @author jose
 */
@WebServlet(name = "FilesServlet", urlPatterns = {"/v1/files"})
@MultipartConfig(location = "/tmp")
public class FilesServlet extends HttpServlet {
    
    private static final String PATH = "/home/jose/server";
    private static final String PART_NAME = "datafile";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart(PART_NAME);
        String carnet = req.getParameter("carnet");
        // el resto de codigo a una clase del backend de servicio
        String fileName = filePart.getContentType();
        System.out.println(filePart.getContentType());
        System.out.println(filePart.getSubmittedFileName());
        System.out.println(filePart.getHeader("Content-disposition"));
        InputStream fileStream = filePart.getInputStream();
        
        System.out.println("carnet: " + carnet);
        
        String finalPath = PATH + File.separatorChar + carnet + "." + FilenameUtils.getExtension(filePart.getSubmittedFileName());
        filePart.write(finalPath);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carnet = req.getParameter("carnet");
        String fileName = carnet + ".pdf";
        String finalPath = PATH + File.separatorChar + fileName;
        
        File file = new File(finalPath);
        FileInputStream inputStream = new FileInputStream(file);
        
        resp.setContentType("application/pdf");
        resp.setHeader("Content-disposition", "attachement; filename=" + fileName);
        resp.getOutputStream().write(inputStream.readAllBytes());
        inputStream.close();
    }
    
}
