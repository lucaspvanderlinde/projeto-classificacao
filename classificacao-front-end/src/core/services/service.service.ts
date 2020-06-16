import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empresa } from '../models/Empresa';

@Injectable({
    providedIn: 'root'
})

export class Service {

    constructor(private http: HttpClient) { }

    Url = 'http://localhost:8080/empresas';

    public getEmpresas() {
        return this.http.get<Empresa[]>(this.Url);
    }

    public postJson(json: File, id: number) {
        const formData = new FormData();
        formData.append('json', json);
        return this.http.post<any>(`${this.Url}/${id}`, formData);
    }
}
