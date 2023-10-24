import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Estudiante } from 'src/entities/Estudiante';
import { EstudianteService } from 'src/services/estudiantes/EstudianteService';

@Component({
  selector: 'app-student-view',
  templateUrl: './student-view.component.html',
  styleUrls: ['./student-view.component.css']
})
export class StudentViewComponent implements OnInit {

  @Input()
  student!: Estudiante;

  constructor(private studentService: EstudianteService,
    private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.student = {
      carnet: '',
      apellido: '',
      fechaNacimiento: '',
      nombre: ''
    };
    this.studentService.getStudent(this.route.snapshot.params['carnet']).subscribe({
      next: (student: Estudiante) => {
        this.student = student;
      }
    });
  }
}
