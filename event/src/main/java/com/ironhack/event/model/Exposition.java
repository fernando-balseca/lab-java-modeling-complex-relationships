package com.ironhack.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "exposition_id")
public class Exposition extends Event{

    public Exposition() {
    }

    public Exposition(LocalDate date, Integer duration, String location, String title) {
        super(date, duration, location, title);
    }
}
