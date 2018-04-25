package softuni._02usersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._02usersystem.repositories.AlbumRepo;

import javax.transaction.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 13:00 ч.
 */

@Service
@Transactional
public class AlbumServiceImpl
        implements AlbumService {

    private final AlbumRepo albumRepo;

    @Autowired
    public AlbumServiceImpl(AlbumRepo albumRepo) {
        this.albumRepo = albumRepo;
    }
}