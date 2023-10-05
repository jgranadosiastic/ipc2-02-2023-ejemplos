import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {
  estudianteForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) {

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
    //if (this.estudianteForm.valid) {
      console.log(this.estudianteForm);
    //}
  }

  limpiar() :void {
    this.estudianteForm.reset({
      
    });
    console.log("reset");
  }


}
