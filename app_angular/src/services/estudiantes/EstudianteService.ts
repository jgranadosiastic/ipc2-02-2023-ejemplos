import { Injectable } from "@angular/core";
import { Estudiante } from "../../entities/Estudiante";
import { HttpClient } from "@angular/common/http"
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class EstudianteService {

    readonly API_URL = "http://localhost:8080/app_agular_api/v1/";

    constructor(private httpClient: HttpClient) {}

    public createEstudiante(estudiante: Estudiante): Observable<Estudiante> {
        console.log('connectando con el BE: ' + estudiante);
        return this.httpClient.post<Estudiante>(this.API_URL + "students", estudiante);
    }

    public getAllStudents(): Observable<Estudiante[]> {
        return this.httpClient.get<Estudiante[]>(this.API_URL + "students");
    }

    public getStudent(carnet: string): Observable<Estudiante> {
        return this.httpClient.get<Estudiante>(this.API_URL + "students?carnet=" + carnet);
    }
}