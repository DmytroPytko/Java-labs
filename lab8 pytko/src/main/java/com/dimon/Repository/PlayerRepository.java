package com.dimon.Repository;

import com.dimon.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
