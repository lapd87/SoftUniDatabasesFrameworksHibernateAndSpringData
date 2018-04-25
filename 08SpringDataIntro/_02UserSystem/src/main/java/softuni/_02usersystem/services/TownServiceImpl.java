package softuni._02usersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._02usersystem.models.entity.Town;
import softuni._02usersystem.repositories.TownRepo;

import javax.transaction.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 13:03 ч.
 */
@Service
@Transactional
public class TownServiceImpl
        implements TownService {

    private final TownRepo townRepo;

    @Autowired
    public TownServiceImpl(TownRepo townRepo) {
        this.townRepo = townRepo;
    }

    @Override
    public Town getTownById(Long id) {
        return this.townRepo.findById(id);
    }

    @Override
    public void registerTown(Town town) {
        this.townRepo.saveAndFlush(town);
    }
}