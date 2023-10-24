import { Component, Input } from '@angular/core';
import { Estudiante } from 'src/entities/Estudiante';

@Component({
  selector: 'app-student-card',
  templateUrl: './student-card.component.html',
  styleUrls: ['./student-card.component.css']
})
export class StudentCardComponent {

  @Input()
  estudiante!: Estudiante;
  @Input()
  verDetalle: boolean;

  constructor() {
    this.verDetalle = true;
  }
}
