package com.hateos_app.Hateos_app.Entities;

import jakarta.persistence.*;

@Entity
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String team;
    private Integer champions;
    private Integer totalGoals;
    private Boolean isGoalkeeper;

    public Players(String nome, Long id, String team, Integer champions, Integer totalGoals, Boolean isGoalkeeper) {
        this.nome = nome;
        this.id = id;
        this.team = team;
        this.champions = champions;
        this.totalGoals = totalGoals;
        this.isGoalkeeper = isGoalkeeper;
    }

    public Players() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getTotalGoals() {
        return totalGoals;
    }

    public void setTotalGoals(Integer totalGoals) {
        this.totalGoals = totalGoals;
    }

    public Integer getChampions() {
        return champions;
    }

    public void setChampions(Integer champions) {
        this.champions = champions;
    }

    public Boolean getGoalkeeper() {
        return isGoalkeeper;
    }

    public void setIsGoalkeeper(Boolean isGoalkeeper) {
        this.isGoalkeeper = isGoalkeeper;
    }
}
