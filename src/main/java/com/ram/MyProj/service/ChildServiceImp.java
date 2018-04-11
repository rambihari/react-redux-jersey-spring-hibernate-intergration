package com.ram.MyProj.service;

import com.ram.MyProj.dao.ChildDao;
import com.ram.MyProj.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChildServiceImp implements ChildService{

    @Autowired
    private ChildDao childDao;

    @Override
    public List<Child> getAllChildren() {
        List<Child> allChildren = childDao.getAll();
        return allChildren;
    }

    @Override
    public void updateChild(Child child) {
        childDao.update(child);
    }

    @Override
    public void addChild(Child child) {
        childDao.addChild(child);
    }

    @Override
    public void deleteChild(int childId) {
        childDao.delete(childId);
    }

    @Override
    public Child getSingleChild(int childId) {
        Child child = childDao.getSingleChild(childId);
        return child;
    }
}
