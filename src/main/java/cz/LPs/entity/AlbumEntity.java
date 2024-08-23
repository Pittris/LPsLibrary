package cz.LPs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "album")
@Getter
@Setter
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String name;
    String genre;
    LocalDate releaseYear;
    @ManyToOne
    InterpretEntity interpret;
}
