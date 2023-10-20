import { Component } from '@angular/core';
import { Estudiante } from 'src/entities/Estudiante';
import { EstudianteService } from 'src/services/estudiantes/EstudianteService';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent {
  studentList: Estudiante[] = [{
    carnet: "xxxxx",
    apellido: "aaaaa",
    nombre: "bbb",
    fechaNacimiento: "ssss"
  },{
    carnet: "xxxxx",
    apellido: "aaaaa",
    nombre: "bbb",
    fechaNacimiento: "ssss"
  }];

  constructor(private estudianteService: EstudianteService) {

  }
}
