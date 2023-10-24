import { Component, OnInit } from '@angular/core';
import { Estudiante } from 'src/entities/Estudiante';
import { EstudianteService } from 'src/services/estudiantes/EstudianteService';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  studentList: Estudiante[] = [];

  constructor(private estudianteService: EstudianteService) {

  }

  ngOnInit(): void {
    this.estudianteService.getAllStudents().subscribe({
      next: (list: Estudiante[]) => {
        this.studentList = list;
      }
  });
  }
}
