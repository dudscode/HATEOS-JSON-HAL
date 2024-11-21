import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

export interface Link {
  rel: string;
  href: string;
}
export interface Player {
  id: number;
  nome: string;
  team: string;
  champions: number;
  totalGoals: number;
  isGoalkeeper: boolean;
  links: Link[];
}

@Injectable({
  providedIn: 'root',
})
export class PlayersService {
  
  constructor(private http: HttpClient) {}
  
  
  
  getAllPlayers(): Observable<Player[]> {
    const url = 'http://localhost:8080/players';
    return this.http.get<Player[]>(url);
  }

  getPlayerById(url: string): Observable<Player> {
    return this.http.get<Player>(url);
  }
}
