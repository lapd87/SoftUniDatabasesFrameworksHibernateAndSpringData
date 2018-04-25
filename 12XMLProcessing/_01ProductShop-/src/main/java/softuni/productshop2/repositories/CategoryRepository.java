package softuni.productshop2.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.productshop2.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


}