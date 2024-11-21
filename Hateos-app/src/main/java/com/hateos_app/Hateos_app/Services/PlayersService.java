package com.hateos_app.Hateos_app.Services;

import com.hateos_app.Hateos_app.Entities.Players;
import com.hateos_app.Hateos_app.Repositories.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayersService {
    @Autowired
    private PlayersRepository playersRepository;

    public List<Players> findAllPlayers() {
        return playersRepository.findAll();
    }

    public Optional<Players> findPlayerById(Long idPlayer) {
        return playersRepository.findById(idPlayer);
    }

    public Players savePlayer(Players player) {
        return  playersRepository.save(player);
    }

    public void deletePlayer(Long idPlayer) {
        playersRepository.deleteById(idPlayer);
    }



}
