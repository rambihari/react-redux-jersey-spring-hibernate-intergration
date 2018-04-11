package com.ram.MyProj.service;

import com.ram.MyProj.model.Profile;

public interface ProfileService {

    Profile getProfile(int ChildId);

    Profile saveProfile(int childId, Profile profile);
}
