package softuni.productshop.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.productshop.model.dto.view.UserSellerDto;
import softuni.productshop.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByIdIs(Long id);

    @Query("SELECT u FROM User AS u " +
            "JOIN Product AS p ON p.seller.id = u.id " +
            "WHERE p.buyer IS NOT NULL " +
            "GROUP BY u.id " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findAllUsersWithSoldProducts();

}