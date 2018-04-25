package softuni._02usersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._02usersystem.models.entity.Country;
import softuni._02usersystem.repositories.CountryRepo;

import javax.transaction.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 13:01 ч.
 */
@Service
@Transactional
public class CountryServiceImpl
        implements CountryService {

    private final CountryRepo countryRepo;

    @Autowired
    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public Country getCountryById(Long id) {
        return this.countryRepo.findById(id);
    }

    @Override
    public void registerCountry(Country country) {
        this.countryRepo.saveAndFlush(country);
    }
}