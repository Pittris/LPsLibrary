package cz.LPs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDto {
    private Integer id;
    private String name;
    private InterpretDto interpret;
    private AlbumDto album;
    private Integer interpretId;
    private Integer albumId;
}
