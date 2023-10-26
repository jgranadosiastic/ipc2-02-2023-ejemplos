import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class FileService {

    constructor(private httpClient: HttpClient) {

    }

    readonly DOWNLOAD_URL = "http://localhost:8080/app_agular_api/v1/files";

    readonly API_URL = "http://localhost:8080/app_agular_api/v1/files";

    public downloadFile(carnet: string): string {
        return this.DOWNLOAD_URL + "?carnet=" + carnet;
    }

    public uploadFile(carnet: string, fileToUpload: File): Observable<void> {
        let formData: FormData = new FormData();
        formData.append("datafile", fileToUpload, fileToUpload.name);

        return this.httpClient.post<void>(this.API_URL + "?carnet=" + carnet, formData);
    }
}