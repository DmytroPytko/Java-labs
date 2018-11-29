package com.dimon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.dimon.DTO.EntityInterface;

import javax.persistence.*;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "team", schema = "lab_8_petko")
public class Team implements EntityInterface {
    private Long id;
    private int code_team;

    public Team(Long id, int code_team) {
        this.id = id;
        this.code_team = code_team;
    }

    private Set<Player> playerByTeam;

    @Id
    @Column(name = "id_of_team", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team(Long id) {
        this.id = id;
    }

    public Team() {
    }

    @Basic
    @Column(name = "code_team", nullable = true)
    public int getCode_team() {
        return code_team;
    }

    public void setCode_team(int code_team) {
        this.code_team = code_team;
    }


    @OneToMany(
            mappedBy = "teamByTeam",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    public Set<Player> getPlayer() {
        return playerByTeam;
    }
    public void setPlayer(Set<Player> players)
    {
        this.playerByTeam = players;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team that = (Team) o;
        return id == that.id &&
                Objects.equals(code_team, that.code_team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code_team);
    }
    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", code_team='" + code_team + '\'' +
                '}';
    }

}
