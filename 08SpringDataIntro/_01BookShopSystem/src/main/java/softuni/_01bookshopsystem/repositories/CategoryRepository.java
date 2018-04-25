package softuni._01bookshopsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni._01bookshopsystem.models.entity.Category;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:10 ч.
 */
@Repository
public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}
