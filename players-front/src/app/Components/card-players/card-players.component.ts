import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { Player, PlayersService } from '../../Services/players/players.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card-players',
  standalone: true,
  imports: [
    MatCardModule,
    CommonModule
  ],
  templateUrl: './card-players.component.html',
  styleUrl: './card-players.component.scss'
})
export class CardPlayersComponent {
  @Input() players: Player[] = [];
  playerSelected: Player | null = null;

  constructor(
    private playersService: PlayersService
  ) { }

  selectPlayer(player: Player) {
    this.playersService.getPlayerById(player.links[0].href).subscribe((response) => {
      this.playerSelected = response;
    });
  }
}
