package app.repositories;

import app.model.labels.Label;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.labels.BasicLabel;

@Repository
public interface BasicLabelRepository extends JpaRepository<BasicLabel, Long> {

}