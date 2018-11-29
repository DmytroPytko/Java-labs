package com.dimon.controller;

import com.dimon.DTO.impl.ReplacementDTO;
import com.dimon.domain.Replacement;
import com.dimon.exceptions.ExistsPlayersForReplacementException;
import com.dimon.exceptions.NoSuchPlayerException;
import com.dimon.exceptions.NoSuchReplacementException;
import com.dimon.service.ReplacementService;
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
public class ReplacementController {
    @Autowired
    ReplacementService replacementService;

    @GetMapping(value = "/api/replacement/player/{player_id}")
    public ResponseEntity<Set<ReplacementDTO>> getReplacementByPlayerID(@PathVariable Long player_id) throws NoSuchPlayerException, NoSuchReplacementException {
        Set<Replacement> replacementSet = replacementService.getReplacementsByPlayerId(player_id);
        Link link = linkTo(methodOn(ReplacementController.class).getAllReplacements()).withSelfRel();

        Set<ReplacementDTO> replacementDTOS = new HashSet<>();
        for (Replacement entity : replacementSet) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ReplacementDTO dto = new ReplacementDTO(entity, selfLink);
            replacementDTOS.add(dto);
        }

        return new ResponseEntity<>(replacementDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/api/replacement/{replacement_id}")
    public ResponseEntity<ReplacementDTO> getReplacement(@PathVariable Long replacement_id) throws NoSuchReplacementException, NoSuchPlayerException {
        Replacement replacement = replacementService.getReplacement(replacement_id);
        Link link = linkTo(methodOn(ReplacementController.class).getReplacement(replacement_id)).withSelfRel();

        ReplacementDTO replacementDTO = new ReplacementDTO(replacement, link);

        return new ResponseEntity<>(replacementDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/replacement")
    public ResponseEntity<Set<ReplacementDTO>> getAllReplacements() throws NoSuchReplacementException, NoSuchPlayerException {
        List<Replacement> replacements = replacementService.getAllReplacements();
        Link link = linkTo(methodOn(ReplacementController.class).getAllReplacements()).withSelfRel();

        Set<ReplacementDTO> replacementDTOS = new HashSet<>();
        for (Replacement entity : replacements) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ReplacementDTO dto = new ReplacementDTO(entity, selfLink);
            replacementDTOS.add(dto);
        }

        return new ResponseEntity<>(replacementDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/replacement")
    public ResponseEntity<ReplacementDTO> addReplacement(@RequestBody Replacement newReplacement) throws NoSuchReplacementException, NoSuchPlayerException {
        replacementService.createReplacement(newReplacement);
        Link link = linkTo(methodOn(ReplacementController.class).getReplacement(newReplacement.getId())).withSelfRel();

        ReplacementDTO replacementDTO = new ReplacementDTO(newReplacement, link);

        return new ResponseEntity<>(replacementDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/replacement/{replacement_id}")
    public ResponseEntity<ReplacementDTO> updateReplacement(@RequestBody Replacement uReplacement, @PathVariable Long replacement_id) throws NoSuchReplacementException, NoSuchPlayerException {
        replacementService.updateReplacement(uReplacement, replacement_id);
        Replacement replacement = replacementService.getReplacement(replacement_id);
        Link link = linkTo(methodOn(ReplacementController.class).getReplacement(replacement_id)).withSelfRel();

        ReplacementDTO replacementDTO = new ReplacementDTO(replacement, link);

        return new ResponseEntity<>(replacementDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/replacement/{replacement_id}")
    public  ResponseEntity deleteReplacement(@PathVariable Long replacement_id) throws ExistsPlayersForReplacementException, NoSuchReplacementException {
        replacementService.deleteReplacement(replacement_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
