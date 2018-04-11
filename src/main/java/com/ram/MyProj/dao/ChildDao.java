package com.ram.MyProj.dao;

import com.ram.MyProj.model.Child;

import java.util.List;

public interface ChildDao {
    List<Child> getAll();

    void update(Child child);
    void addChild(Child child);
    void delete(int childId);

    Child getSingleChild(int childId);
}
