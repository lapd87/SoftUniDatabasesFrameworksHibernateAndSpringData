package softuni._02usersystem.services;

import softuni._02usersystem.models.entity.Country;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 12:59 ч.
 */
public interface CountryService {

    Country getCountryById(Long id);

    void registerCountry(Country country);

}
