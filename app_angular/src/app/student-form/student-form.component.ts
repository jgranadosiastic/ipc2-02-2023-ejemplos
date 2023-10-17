import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Estudiante } from '../../entities/Estudiante';
import { EstudianteService } from '../../services/estudiantes/EstudianteService';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {
  estudianteForm!: FormGroup;
  estudiante!: Estudiante;
  saved: boolean;

  constructor(private formBuilder: FormBuilder,
    private estudianteService: EstudianteService) {
    this.saved = false;

  }

  ngOnInit(): void {
    this.estudianteForm = this.formBuilder.group({
      carnet: [null, [Validators.required, Validators.maxLength(10)]],
      nombre: [null, [Validators.required, Validators.maxLength(25)]],
      apellidos: [null, [Validators.required, Validators.maxLength(25)]],
      fechaNacimiento: [null]
    });
  }

  submit(): void {
    if (this.estudianteForm.valid) {
      this.estudiante = this.estudianteForm.value as Estudiante;
      this.estudianteService.createEstudiante(this.estudiante).subscribe({
        next: (created: Estudiante) => {
          console.log("creataeds" + created);
          this.limpiar();
          this.saved = true;
        },
        error: (error: any) => {
          console.log("error");
        }
      });
    }
  }

  limpiar(): void {
    this.estudianteForm.reset({

    });

  }


}
