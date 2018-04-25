package softuni._02usersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni._02usersystem.models.entity.Album;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 12:54 ч.
 */
@Repository
public interface AlbumRepo
        extends JpaRepository<Album, Long> {


}