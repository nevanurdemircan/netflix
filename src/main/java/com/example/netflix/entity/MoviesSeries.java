package com.example.netflix.entity;

import com.example.netflix.enums.Genre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class MoviesSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Genre type;

    private String releaseDate;
    private double imdbRating;
    private double userRating;
    private String trailerUrl;
    private String imageUrl;


    @OneToMany(mappedBy = "moviesSeries", cascade = CascadeType.ALL)
    private List<Section> sections;
}
