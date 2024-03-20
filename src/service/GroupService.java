package service;

import group.Group;

import java.util.List;

public interface GroupService {
    List<Group> addNewGroups();

    public Group getGroup();

    public Group updateGroup();

    public List<Group> getAllGroup();
}
