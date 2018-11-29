package com.dimon.controller;

import com.dimon.DTO.impl.TeamDTO;
import com.dimon.domain.Team;

import com.dimon.exceptions.*;
import com.dimon.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping(value = "/api/team")
    public ResponseEntity<Set<TeamDTO>> getAllTeams() throws NoSuchPlayerException, NoSuchReplacementException, NoSuchTeamException {
        List<Team> teamList = teamService.getAllTeams();
        Link link = linkTo(methodOn(TeamController.class).getAllTeams()).withSelfRel();

        Set<TeamDTO> teamDTOS = new HashSet<>();
        for (Team entity : teamList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            TeamDTO dto = new TeamDTO(entity, selfLink);
            teamDTOS.add(dto);
        }

        return new ResponseEntity<>(teamDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/api/team/{team_id}")
    public ResponseEntity<TeamDTO> getTeam(@PathVariable Long team_id) throws NoSuchTeamException, NoSuchPlayerException, NoSuchReplacementException {
        Team team = teamService.getTeam(team_id);
        Link link = linkTo(methodOn(TeamController.class).getTeam(team_id)).withSelfRel();
        System.out.println(team);
        TeamDTO teamDTO = new TeamDTO(team, link);

        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/team/{team_id}")
    public  ResponseEntity<TeamDTO> addTeam(@RequestBody Team team) throws NoSuchTeamException, NoSuchPlayerException, NoSuchReplacementException {
        teamService.createTeam(team);
        Link link = linkTo(methodOn(TeamController.class).getTeam(team.getId())).withSelfRel();

        TeamDTO teamDTO = new TeamDTO(team, link);

        return new ResponseEntity<>(teamDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/team/{team_id}")
    public  ResponseEntity<TeamDTO> updateTeam(@RequestBody Team uTeam, @PathVariable Long team_id) throws NoSuchTeamException, NoSuchPlayerException, NoSuchReplacementException {
        teamService.updateTeam(uTeam, team_id);
        Team team = teamService.getTeam(team_id);
        Link link = linkTo(methodOn(TeamController.class).getTeam(team_id)).withSelfRel();

        TeamDTO teamDTO = new TeamDTO(team, link);

        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/team/{team_id}")
    public  ResponseEntity deleteTeam(@PathVariable Long team_id) throws NoSuchTeamException, ExistsPlayersForReplacementException, ExistsPlayersForTeamException {
        teamService.updateTeam(team_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
