package com.edu.uptc.apieventos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="assistants")
public class Assistant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable= false)
    private String name;

    @Column(nullable= false)
    private String email;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name="fk_assistant_to_event"))
    @JsonIgnore
    private Event event;

    public Assistant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
