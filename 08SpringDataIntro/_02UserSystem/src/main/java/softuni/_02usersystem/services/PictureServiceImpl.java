package softuni._02usersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._02usersystem.repositories.PictureRepo;

import javax.transaction.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 13:02 ч.
 */
@Service
@Transactional
public class PictureServiceImpl
        implements PictureService {

    private final PictureRepo pictureRepo;

    @Autowired
    public PictureServiceImpl(PictureRepo pictureRepo) {
        this.pictureRepo = pictureRepo;
    }
}