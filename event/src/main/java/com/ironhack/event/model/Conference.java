package com.ironhack.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "conference_id")
public class Conference extends Event{

    @OneToMany(mappedBy = "conference", fetch = FetchType.LAZY)
    private List<Speaker> speakers = new ArrayList<>();

    public Conference() {
    }

    public Conference(LocalDate date, Integer duration, String location, String title) {
        super(date, duration, location, title);
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
