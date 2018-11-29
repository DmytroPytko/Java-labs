package com.dimon.DTO.impl;

import com.dimon.DTO.DTO;
import com.dimon.domain.Player;
import com.dimon.domain.Team;
import com.dimon.exceptions.NoSuchPlayerException;
import com.dimon.exceptions.NoSuchTeamException;
import com.dimon.exceptions.NoSuchReplacementException;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class PlayerDTO extends DTO<Player> {
    public PlayerDTO(Player player, Link link) throws NoSuchReplacementException, NoSuchTeamException, NoSuchPlayerException {
        super(player, link);
    }

    public Long getPlayerId() {
        return getEntity().getId();
    }

    public String getNameOfPlayer() {
        return getEntity().getNameOfPlayer();
    }

    public String getSurnameOfPlayer() {
        return getEntity().getSurnameOfPlayer();
    }

    public Team getTeam() {
        return getEntity().getTeamByTeam();
    }


}
