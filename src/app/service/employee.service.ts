import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';
import { Employee } from '../employee/employee';

@Injectable()
export class EmployeeService {
constructor(private httpClient: HttpClient) { }

serverUrl: string = "http://localhost:8080/"

get(url: string): Observable<any> {
    return this.httpClient.get(this.serverUrl + url);
}

post(url: string, data: Employee): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
}

put(url: string, data: Employee): Observable<any> {
    return this.httpClient.put(this.serverUrl + url, data);
}

}