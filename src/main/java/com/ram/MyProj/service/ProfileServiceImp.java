package com.ram.MyProj.service;

import com.ram.MyProj.dao.ProfileDao;
import com.ram.MyProj.model.Profile;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Service
@Transactional
public class ProfileServiceImp implements ProfileService {

    @Inject
    private ProfileDao profileDao;

    @Override
    public Profile getProfile(int childId) {
        Profile profile = profileDao.getProfile(childId);
        return profile;
    }

    @Override
    public Profile saveProfile(int childId, Profile profileToBeSaved) {
        Profile profile = profileDao.saveProfile(childId, profileToBeSaved);
        return profile;
    }
}
