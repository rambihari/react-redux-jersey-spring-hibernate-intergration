package com.ram.MyProj.dao;

import com.ram.MyProj.model.Child;
import com.ram.MyProj.model.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("childDao")
public class ChildDaoImp implements ChildDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Child> getAll() {
        // Retrieving and returning a list of all the children present in the database
        List<Child> children =  (List<Child>) entityManager.createQuery("from Child").getResultList();
        return children;
    }

    @Override
    public void update(Child child) {
        entityManager.merge(child);
    } //Updating a child which already exists in database

    @Override
    public void addChild(Child child) {
        //Adding a new child to the database while also initializing the profile of the child
        Profile profile = new Profile();
        child.setProfile(profile);
        entityManager.persist(child);
    }

    @Override
    public void delete(int childId) {
        //Removing the child from database
        Child childToBeRemoved = entityManager.find(Child.class, childId);
        entityManager.remove(childToBeRemoved);
    }

    @Override
    public Child getSingleChild(int childId) {
        //retrieving and returning a single child based on childID which was provided
        Child child = entityManager.find(Child.class, childId);
        return child;
    }
}
