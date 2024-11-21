package com.hateos_app.Hateos_app.Controllers;

import com.hateos_app.Hateos_app.Entities.Players;
import com.hateos_app.Hateos_app.Repositories.PlayersRepository;
import com.hateos_app.Hateos_app.Services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayersController {

    @Autowired
    private PlayersService playersService;

    @GetMapping
    public List<EntityModel<Players>> getAllPlayers() {
        List<Players> players = playersService.findAllPlayers();
        return  players.stream().map(
                player -> EntityModel.of(player,
                        WebMvcLinkBuilder.linkTo(
                                WebMvcLinkBuilder.methodOn(PlayersController.class).getPlayerById(player.getId())
                        ).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(
                                WebMvcLinkBuilder.methodOn(PlayersController.class).deletePlayer(player.getId())
                        ).withRel("deletinho")

                )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Players> getPlayerById(@PathVariable Long id) {
        Players player = playersService.findPlayerById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        Link selfLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PlayersController.class).getPlayerById(id)
        ).withSelfRel();

        Link allPlayersLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PlayersController.class).getAllPlayers()
        ).withRel("all-players");

        return EntityModel.of(player, selfLink, allPlayersLink);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playersService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public EntityModel<Players> addPlayer(@RequestBody Players player) {
        Players savedPlayer = playersService.savePlayer(player);

        return EntityModel.of(savedPlayer,
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(PlayersController.class).getPlayerById(savedPlayer.getId())
                ).withSelfRel()
        );
    }

}
