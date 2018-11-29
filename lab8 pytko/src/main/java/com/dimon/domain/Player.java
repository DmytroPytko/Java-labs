package com.dimon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.dimon.DTO.EntityInterface;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "player", schema = "lab_8_petko")
public class Player implements EntityInterface {
    private Long id;
    private String nameOfPlayer;
    private String surnameOfPlayer;
    private Team teamByTeam;
    Set<Replacement> replacements = new HashSet<>();


    public Player(String catery, String surnameOfPlayer, Team teamByTeam) {
        this.nameOfPlayer = catery;
        this.surnameOfPlayer = surnameOfPlayer;
        this.teamByTeam = teamByTeam;
    }

    public Player(Long id, String nameOfPlayer, String surnameOfPlayer) {
        this.id = id;
        this.nameOfPlayer = nameOfPlayer;
        this.surnameOfPlayer = surnameOfPlayer;
    }

    public Player() {
    }


    @Id
    @Column(name = "id_of_player", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_of_player", nullable = true, length = 50)
    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }

    @Basic
    @Column(name = "surname_of_player", nullable = true, length = 50)
    public String getSurnameOfPlayer() {
        return surnameOfPlayer;
    }

    public void setSurnameOfPlayer(String surnameOfPlayer) {
        this.surnameOfPlayer = surnameOfPlayer;
    }

    @ManyToOne
    @JoinColumn(name = "id_of_team", referencedColumnName = "id_of_team", nullable = false)
    @JsonIgnore
    public Team getTeamByTeam() {
        return teamByTeam;
    }

    public void setTeamByTeam(Team teamByTeam) {
        this.teamByTeam = teamByTeam;
    }


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "player_replacement",
            joinColumns = { @JoinColumn(name = "id_of_player", referencedColumnName = "id_of_player", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_of_replacement", referencedColumnName = "id_of_replacement", nullable = false), }
    )
    @JsonIgnore
    public Set<Replacement> getReplacements() {
        return replacements;
    }

    public void setReplacements(Set<Replacement> replacements) {
        this.replacements = replacements;
    }

    public void addPlayerReplacement(Replacement replacement){
        if(!getReplacements().contains(replacement)){
            getReplacements().add(replacement);
        }
        if(!replacement.getPlayerSet().contains(this)){
            replacement.getPlayerSet().add(this);
        }
    }

    public void deleteReplacementEntity(Replacement replacement){
        if(getReplacements().contains(replacement)){
            getReplacements().remove(replacement);
        }
        if(replacement.getPlayerSet().contains(this)){
            replacement.getPlayerSet().remove(this);
        }
    }



    @Override
    public String toString() {
        return "MobileEntity{" +
                "id=" + id +
                ", category='" + nameOfPlayer + '\'' +
                ", mark1='" + surnameOfPlayer + '\'' +
                ", replacements=" + replacements +
                '}';
    }

    public String toStringJoinTable(){
        return "Player{" +
                "id=" + id +
                " replacements=" + replacements +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player that = (Player) o;
        return id == that.id &&
                Objects.equals(nameOfPlayer, that.nameOfPlayer) &&
                Objects.equals(surnameOfPlayer, that.surnameOfPlayer);}


    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfPlayer, surnameOfPlayer);
    }



}
