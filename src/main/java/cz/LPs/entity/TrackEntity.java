package cz.LPs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "track")
@Getter
@Setter
public class TrackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String name;
    @ManyToOne
    AlbumEntity album;
    @ManyToOne
    InterpretEntity interpret;
}
