package com.ram.MyProj.service;

import com.ram.MyProj.model.Child;

import java.util.List;

public interface ChildService {

    List<Child> getAllChildren();

    void updateChild(Child child);

    void addChild(Child child);

    void deleteChild(int childId);

    Child getSingleChild(int childId);
}
