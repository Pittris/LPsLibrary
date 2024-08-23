package cz.LPs.repository;

import cz.LPs.entity.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<TrackEntity, Integer> {

}
