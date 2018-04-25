package softuni._02usersystem.services;

import softuni._02usersystem.models.entity.Town;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 12:59 ч.
 */
public interface TownService {

    Town getTownById(Long id);

    void registerTown (Town town);

}
