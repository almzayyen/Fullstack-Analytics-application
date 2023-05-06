import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tower } from '../models/tower.model';




@Injectable({
  providedIn: 'root'
})
export class TowerService {

  private paginateBaseURL = 'http://localhost:8080/api/paginatedTowerData';
  private  baseURL = 'http://localhost:8080/api/challenge/towers';
  constructor(private http: HttpClient) { }

  getAllTowers(): Observable<Tower[]> {
    return this.http.get<Tower[]>(`${this.baseURL}`);
  }
  getPaginatedTowers(page: number, size: number): Observable<Tower[]> {
    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    return this.http.get<Tower[]>(this.paginateBaseURL, { params: params });
  }
  getTowers(page: number, size: number, sortBy: string): Observable<any> {
    // let params = new HttpParams()
    //   .set('page', page.toString())
    //   .set('size', size.toString())
    //   .set('sortBy', sortBy);

    return this.http.get<any>(this.paginateBaseURL);
  }
  filterTowers(page: number, size: number, networkOperator: string, technology: string, towerType: string): Observable<Tower[]> {
    let params = new HttpParams()
    .set('page', page.toString())
    .set('size', size.toString());
    
    if (networkOperator) {
      params = params.set('networkOperator', networkOperator);
    }
    if (technology) {
      params = params.set('technology', technology);
    }
    if (towerType) {
      params = params.set('towerType', towerType);
    }
    return this.http.get<Tower[]>(this.paginateBaseURL, { params: params });
  }

}
