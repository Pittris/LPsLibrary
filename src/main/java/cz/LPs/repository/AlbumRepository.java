package cz.LPs.repository;

import cz.LPs.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {

}
