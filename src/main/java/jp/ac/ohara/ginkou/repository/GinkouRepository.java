package jp.ac.ohara.ginkou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.ginkou.model.Ginkou;

@Repository
public interface GinkouRepository extends JpaRepository<Ginkou, Long> {	
}