package com.ram.MyProj.dao;

import com.ram.MyProj.model.Profile;

public interface ProfileDao {
    Profile getProfile(int childId);

    Profile saveProfile(int childId, Profile profile);
}
