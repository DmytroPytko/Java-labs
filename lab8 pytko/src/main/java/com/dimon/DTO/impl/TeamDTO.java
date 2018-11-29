package com.dimon.DTO.impl;

import com.dimon.DTO.DTO;
import com.dimon.controller.PlayerController;
import com.dimon.domain.Player;
import com.dimon.domain.Team;
import com.dimon.exceptions.NoSuchPlayerException;
import com.dimon.exceptions.NoSuchTeamException;
import com.dimon.exceptions.NoSuchReplacementException;
import org.springframework.hateoas.Link;

import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


public class TeamDTO extends DTO<Team> {
    public TeamDTO(Team team, Link link) throws NoSuchTeamException, NoSuchReplacementException, NoSuchPlayerException {
        super(team, link);
        add(linkTo(methodOn(PlayerController.class).getPlayersByTeamId(getEntity().getId())).withRel("mobile"));
    }

    public Long getPlayerId() {
        return getEntity().getId();
    }

    public Integer getCode_team() {
        return getEntity().getCode_team();
    }
  

    public Set<Player> getPlayer() {
        return getEntity().getPlayer();
    }
}
