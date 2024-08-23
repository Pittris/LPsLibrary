package cz.LPs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Integer id;
    private String name;
    private String genre;
    private LocalDate releaseYear;
    private InterpretDto interpret;
    private Integer interpretId;
}
