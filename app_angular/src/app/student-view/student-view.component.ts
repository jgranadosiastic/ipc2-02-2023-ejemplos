import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Estudiante } from 'src/entities/Estudiante';
import { EstudianteService } from 'src/services/estudiantes/EstudianteService';
import { FileService } from 'src/services/files/FileService';



@Component({
  selector: 'app-student-view',
  templateUrl: './student-view.component.html',
  styleUrls: ['./student-view.component.css']
})
export class StudentViewComponent implements OnInit {

  @Input()
  student!: Estudiante;

  downloadUrl: string;
  selectedFile!: File;
  fileUploaded: boolean = false;

  constructor(private studentService: EstudianteService,
    private route: ActivatedRoute,
    private fileService: FileService) {
    this.downloadUrl = '';
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
        this.downloadUrl = this.fileService.downloadFile(student.carnet);
      }
    });
  }

  uploadToServer() : void {
    this.fileUploaded = false;
    if (this.selectedFile != null) {
      this.fileService.uploadFile(this.student.carnet, this.selectedFile).subscribe({
        next: () => {
          this.fileUploaded = true;
        }
      });
    }
  }

  processFile(event: Event): void {
    let files = (event.target as HTMLInputElement).files;
    if (files != null) {
      this.selectedFile = files[0];
    }
  }
}
