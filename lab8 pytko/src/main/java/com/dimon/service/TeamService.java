package com.dimon.service;

import com.dimon.Repository.TeamRepository;
import com.dimon.Repository.PlayerRepository;
import com.dimon.domain.Team;
import com.dimon.exceptions.ExistsPlayersForTeamException;
import com.dimon.exceptions.NoSuchTeamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;
    private boolean ascending;

    @Autowired
    PlayerRepository studentRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeam(Long player_id) throws NoSuchTeamException {
        Team team = teamRepository.findById(player_id).get();//2.0.0.M7
        System.out.println(team);
        if (team == null) throw new NoSuchTeamException();
        return team;
    }

    @Transactional
    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    @Transactional
    public void updateTeam(Team team, Long player_id) throws NoSuchTeamException {
        Team team1 = teamRepository.findById(player_id).get();//2.0.0.M7

        if (team1 == null) throw new NoSuchTeamException();
        team1.setPlayer(team.getPlayer());
        teamRepository.save(team1);
    }

    @Transactional
    public void updateTeam(Long player_id) throws NoSuchTeamException, ExistsPlayersForTeamException {
        Team team = teamRepository.findById(player_id).get();//2.0.0.M7
        if (team == null) throw new NoSuchTeamException();
        if (team.getPlayer().size() != 0) throw new ExistsPlayersForTeamException();
        teamRepository.delete(team);
    }


}
