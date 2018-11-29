package com.dimon.domain;

import com.dimon.DTO.EntityInterface;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "replacement", schema = "lab_8_petko")
public class Replacement implements EntityInterface {
    private Long id;
    private String nameOfReplacement;
    private String surnameOfReplacement;
    private Set<Player> players = new HashSet<>();
    @Id
    @Column(name = "id_of_replacement", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_of_replacement", nullable = false, length = 50)
    public String getNameOfReplacement() {
        return nameOfReplacement;
    }

    public void setNameOfReplacement(String nameOfReplacement) {
        this.nameOfReplacement = nameOfReplacement;
    }

    @Basic
    @Column(name = "surname_of_replacement", nullable = true, length = 50)
    public String getSurnameOfReplacement() {
        return surnameOfReplacement;
    }

    public void setSurnameOfReplacement(String surnameOfReplacement) {
        this.surnameOfReplacement = surnameOfReplacement;
    }


    @ManyToMany(targetEntity = Player.class, mappedBy="replacements")
    public Set<Player> getPlayerSet() {
        return players;
    }

    public void setPlayerSet(Set<Player> mobiles) {
        this.players = mobiles;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Replacement that = (Replacement) o;
        return id == that.id &&
                Objects.equals(nameOfReplacement, that.nameOfReplacement) &&
                Objects.equals(surnameOfReplacement, that.surnameOfReplacement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfReplacement, surnameOfReplacement);
    }
    @Override
    public String toString(){
        return "Id= " + id + ", nameOfReplacement= " + nameOfReplacement
                + ", surnameOfReplacement= " + surnameOfReplacement;
    }
}
