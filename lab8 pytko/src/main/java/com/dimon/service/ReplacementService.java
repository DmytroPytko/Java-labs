package com.dimon.service;

import com.dimon.Repository.PlayerRepository;
import com.dimon.Repository.ReplacementRepository;
import com.dimon.domain.Player;
import com.dimon.domain.Replacement;
import com.dimon.exceptions.ExistsPlayersForReplacementException;
import com.dimon.exceptions.NoSuchPlayerException;
import com.dimon.exceptions.NoSuchReplacementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class ReplacementService {
    @Autowired
    ReplacementRepository replacementRepository;

    @Autowired
    PlayerRepository playerRepository;

    public Set<Replacement> getReplacementsByPlayerId(Long player_id) throws NoSuchPlayerException {
        Player player = playerRepository.findById(player_id).get();//2.0.0.M7
        if (player == null) throw new NoSuchPlayerException();
        return player.getReplacements();
    }

    public Replacement getReplacement(Long replacement_id) throws NoSuchReplacementException {
        Replacement replacement = replacementRepository.findById(replacement_id).get();//2.0.0.M7
        if (replacement == null) throw new NoSuchReplacementException();
        return replacement;
    }

    public List<Replacement> getAllReplacements() {
        return replacementRepository.findAll();
    }

    @Transactional
    public void createReplacement(Replacement replacement) {
        replacementRepository.save(replacement);
    }

    @Transactional
    public void updateReplacement(Replacement uReplacement, Long replacement_id) throws NoSuchReplacementException {
        Replacement replacement= replacementRepository.findById(replacement_id).get();//2.0.0.M7
        if (replacement == null) throw new NoSuchReplacementException();
        //update
        replacement.setNameOfReplacement(uReplacement.getNameOfReplacement());
    }

    @Transactional
    public void deleteReplacement(Long replacement_id) throws NoSuchReplacementException, ExistsPlayersForReplacementException {
        Replacement replacement = replacementRepository.findById(replacement_id).get();//2.0.0.M7

        if (replacement == null) throw new NoSuchReplacementException();
        if (replacement.getPlayerSet().size() != 0) throw new ExistsPlayersForReplacementException();
        replacementRepository.delete(replacement);
    }
}
