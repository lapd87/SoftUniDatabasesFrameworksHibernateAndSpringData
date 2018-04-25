package softuni.productshop2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.productshop2.model.dto.view.UserSoldDto;
import softuni.productshop2.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u,ps FROM User AS u " +
            "JOIN u.productsSold AS ps ON ps.seller.id = u.id " +
            "WHERE ps.buyer IS NOT NULL " +
            "GROUP BY u.id " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findByUserWithSoldProductsOrdered();
}