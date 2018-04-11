package com.ram.MyProj.dao;

import com.ram.MyProj.model.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository("profileDao")
public class ProfileDaoImp implements ProfileDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Profile getProfile(int childId) {
        //Creating a query in order to retrieve and return profile of child with childId which was passed in
        Query query = entityManager.createNativeQuery("select p.* from child c inner join Profile p on c.profile_id = p.id where c.id= :childId", Profile.class);
        query.setParameter("childId", childId);
        return (Profile)query.getSingleResult();
    }

    @Override
    public Profile saveProfile(int childId, Profile profileToBeSaved) {
        //Creating a query in order to retrieve profile of child with childId which was pass
        //Changing the Profile from a detached state to a persisted state so we can work with it again
        //Updating profile based on user given values and merge it back into the database
        Query query = entityManager.createNativeQuery("select p.* from child c inner join Profile p on c.profile_id = p.id where c.id= :childId", Profile.class);
        query.setParameter("childId", childId);
        Profile profile = (Profile)query.getSingleResult();
        profile = profileToBeSaved;
        entityManager.merge(profileToBeSaved);
        return profileToBeSaved;
    }
}
