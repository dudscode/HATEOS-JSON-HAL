import { Component } from '@angular/core';
import { HeaderComponent } from '../../Components/header/header.component';
import { CardPlayersComponent } from '../../Components/card-players/card-players.component';
import {MatButtonModule} from '@angular/material/button';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { CommonModule } from '@angular/common';
import { Player, PlayersService } from '../../Services/players/players.service';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
  CommonModule,
   HeaderComponent,
   CardPlayersComponent,
   MatButtonModule,
   MatProgressSpinnerModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  showPlayers = false;
  showLoadingPlayers = false;
  players: Player[] = [];

  constructor(
    private playersService: PlayersService
  ) { }

  searchPlayer() {
    this.showLoadingPlayers = true;
    this.playersService.getAllPlayers().pipe(
      finalize(() => {
        this.showLoadingPlayers = false;
        this.showPlayers = !!this.players.length;
      })
    ).subscribe((response) => {
      this.players = response;
    });

  }
}
