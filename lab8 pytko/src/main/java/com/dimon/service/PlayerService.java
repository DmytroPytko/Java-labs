package com.dimon.service;

import com.dimon.Repository.TeamRepository;
import com.dimon.Repository.PlayerRepository;
import com.dimon.Repository.ReplacementRepository;
import com.dimon.domain.Player;
import com.dimon.domain.Team;
import com.dimon.domain.Replacement;
import com.dimon.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ReplacementRepository replacementRepository;

    public Set<Player> getPlayerByTeamId(Long player_id) throws NoSuchTeamException {
        Team team = teamRepository.findById(player_id).get();//2.0.0.M7
        if (team == null) throw new NoSuchTeamException();
        return team.getPlayer();
    }

    public Player getPlayers(Long player_id) throws NoSuchPlayerException {
        Player player = playerRepository.findById(player_id).get();//2.0.0.M7
        if (player == null) throw new NoSuchPlayerException();
        return player;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Set<Player> getPlayersByReplacementId(Long replacement_id) throws NoSuchReplacementException {
        Replacement replacement = replacementRepository.findById(replacement_id).get();//2.0.0.M7
        if (replacement == null) throw new NoSuchReplacementException();
        return replacement.getPlayerSet();
    }

    @Transactional
    public void createPlayer(Player player, Long team_id) throws NoSuchTeamException {
        if (team_id > 0) {
            Team team = teamRepository.findById(team_id).get();//2.0.0.M7
            if (team == null) throw new NoSuchTeamException();
            player.setTeamByTeam(team);
        }
        playerRepository.save(player);
    }

    @Transactional
    public void updatePlayer(Player uPlayer, Long player_id, Long playerId) throws NoSuchTeamException, NoSuchPlayerException {
        Team team = teamRepository.findById(playerId).get();//2.0.0.M7
        if (playerId > 0) {
            if (team == null) throw new NoSuchTeamException();
        }
        Player player = playerRepository.findById(player_id).get();//2.0.0.M7
        if (player == null) throw new NoSuchPlayerException();
        player.setNameOfPlayer(uPlayer.getNameOfPlayer());
        player.setSurnameOfPlayer(uPlayer.getSurnameOfPlayer());
        if (playerId > 0) player.setTeamByTeam(team);
        else player.setTeamByTeam(null);
        playerRepository.save(player);
    }

    @Transactional
    public void deletePlayer(Long player_id) throws NoSuchPlayerException, ExistsReplacementForPlayerException {
        Player player = playerRepository.findById(player_id).get();//2.0.0.M7
        if (player == null) throw new NoSuchPlayerException();
        if (player.getReplacements().size() != 0) throw new ExistsReplacementForPlayerException();
        playerRepository.delete(player);
    }

    @Transactional
    public void addReplacementForPlayer(Long player_id, Long replacement_id)
            throws NoSuchPlayerException, NoSuchReplacementException, AlreadyExistsReplacementInPlayerException, ReplacementAbsentException {
        Player player = playerRepository.findById(player_id).get();//2.0.0.M7
        if (player == null) throw new NoSuchPlayerException();
        Replacement replacement = replacementRepository.findById(replacement_id).get();//2.0.0.M7
        if (replacement == null) throw new NoSuchReplacementException();
        if (player.getReplacements().contains(replacement) == true) throw new AlreadyExistsReplacementInPlayerException();
        player.getReplacements().add(replacement);
        playerRepository.save(player);
    }

    @Transactional
    public void removeReplacementForPlayer(Long player_id, Long replacement_id)
            throws NoSuchPlayerException, NoSuchReplacementException, PlayerHasNotReplacementException {
        Player player = playerRepository.findById(player_id).get();//2.0.0.M7
        if (player == null) throw new NoSuchPlayerException();
        Replacement replacement= replacementRepository.findById(replacement_id).get();//2.0.0.M7
        if (replacement == null) throw new NoSuchReplacementException();
        if (player.getReplacements().contains(replacement) == false) throw new PlayerHasNotReplacementException();
        player.getReplacements().remove(replacement);
        playerRepository.save(player);
    }
}
