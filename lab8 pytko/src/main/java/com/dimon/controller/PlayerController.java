package com.dimon.controller;

import com.dimon.DTO.impl.PlayerDTO;
import com.dimon.domain.Player;
import com.dimon.exceptions.*;
import com.dimon.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;
// get Player by class id
    @GetMapping(value = "/api/player/team/{team_id}")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeamId(@PathVariable Long team_id) throws NoSuchTeamException, NoSuchPlayerException, NoSuchReplacementException {
        Set<Player> playerByTeamId= playerService.getPlayerByTeamId(team_id);

        Link link = linkTo(methodOn(PlayerController.class).getAllPlayers()).withSelfRel();

        List<PlayerDTO> playerDTOS = new ArrayList<>();
        for (Player entity : playerByTeamId) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            PlayerDTO dto = new PlayerDTO(entity, selfLink);
            playerDTOS.add(dto);
        }

        return new ResponseEntity<>(playerDTOS, HttpStatus.OK);
    }
// get Player
    @GetMapping(value = "/api/player/{player_id}")
    public ResponseEntity<PlayerDTO> getPlayers(@PathVariable Long player_id) throws NoSuchPlayerException, NoSuchReplacementException, NoSuchTeamException {
        Player players = playerService.getPlayers(player_id);
        Link link = linkTo(methodOn(PlayerController.class).getPlayers(player_id)).withSelfRel();

        PlayerDTO playerDTO = new PlayerDTO(players, link);

        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/player")
    public ResponseEntity<Set<PlayerDTO>> getAllPlayers() throws NoSuchPlayerException, NoSuchReplacementException, NoSuchTeamException {
        List<Player> allPlayers = playerService.getAllPlayers();
        Link link = linkTo(methodOn(PlayerController.class).getAllPlayers()).withSelfRel();

        Set<PlayerDTO> playerDTOS = new HashSet<>();
        for (Player entity : allPlayers) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            PlayerDTO dto = new PlayerDTO(entity, selfLink);
            playerDTOS.add(dto);
        }

        return new ResponseEntity<>(playerDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/api/player/replacement/{replacement_id}")
    public ResponseEntity<Set<PlayerDTO>> getPlayersByReplacementID(@PathVariable Long replacement_id) throws NoSuchReplacementException, NoSuchPlayerException, NoSuchTeamException {
        Set<Player> playerSet = playerService.getPlayersByReplacementId(replacement_id);
        Link link = linkTo(methodOn(PlayerController.class).getAllPlayers()).withSelfRel();

        Set<PlayerDTO> playerDTOS = new HashSet<>();
        for (Player entity : playerSet) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            PlayerDTO dto = new PlayerDTO(entity, selfLink);
            playerDTOS.add(dto);
        }

        return new ResponseEntity<>(playerDTOS, HttpStatus.OK);
    }
// add Player
    @PostMapping(value = "/api/player/Team/{team_id}")
    public  ResponseEntity<PlayerDTO> addPlayer(@RequestBody Player player, @PathVariable Long team_id)
            throws NoSuchTeamException, NoSuchPlayerException, NoSuchReplacementException {
        playerService.createPlayer(player, team_id);
        Link link = linkTo(methodOn(PlayerController.class).getPlayers(player.getId())).withSelfRel();

        PlayerDTO playerDTO = new PlayerDTO(player, link);

        return new ResponseEntity<>(playerDTO, HttpStatus.CREATED);
    }
//update Player
    @PutMapping(value = "/api/player/{player_id}/Team/{team_id}")
    public  ResponseEntity<PlayerDTO> updatePlayer(@RequestBody Player student,
                                                   @PathVariable Long player_id, @PathVariable Long team_id)
            throws NoSuchTeamException, NoSuchPlayerException, NoSuchReplacementException {
        playerService.updatePlayer(student, player_id, team_id);
        Player players = playerService.getPlayers(player_id);
        Link link = linkTo(methodOn(PlayerController.class).getPlayers(player_id)).withSelfRel();

        PlayerDTO playerDTO = new PlayerDTO(players, link);

        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/player/{player_id}")
    public  ResponseEntity deletePlayer(@PathVariable Long student_id) throws NoSuchPlayerException, ExistsReplacementForPlayerException, ExistsReplacementForPlayerException {
        playerService.deletePlayer(student_id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/api/player/{player_id}/replacement/{replacement_id}")
    public  ResponseEntity<PlayerDTO> addReplacementForPlayer(@PathVariable Long player_id, @PathVariable Long replacement_id)
            throws NoSuchPlayerException, NoSuchReplacementException, NoSuchTeamException, AlreadyExistsReplacementInPlayerException, ReplacementAbsentException {
        playerService.addReplacementForPlayer(player_id,replacement_id);
        Player players = playerService.getPlayers(player_id);
        Link link = linkTo(methodOn(PlayerController.class).getPlayers(player_id)).withSelfRel();

        PlayerDTO playerDTO = new PlayerDTO(players, link);

        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/player/{player_id}/{replacement_id}")
    public  ResponseEntity<PlayerDTO> removeReplacementForPlayer(@PathVariable Long player_id, @PathVariable Long replacement_id)
            throws NoSuchPlayerException, NoSuchReplacementException, NoSuchTeamException, PlayerHasNotReplacementException {
        playerService.removeReplacementForPlayer(player_id,replacement_id);
        Player players = playerService.getPlayers(player_id);
        Link link = linkTo(methodOn(PlayerController.class).getPlayers(replacement_id)).withSelfRel();

        PlayerDTO playerDTO = new PlayerDTO(players, link);

        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

}

