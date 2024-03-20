package service;

import group.Group;


import java.util.List;

public interface GroupService {

    List<Group> addGroup();

    List<Group> getAllGroups();

    Group getGroupByName(String groupName);

    String upDateGroup(String groupName);

    String deleteGroup(String groupName);
}
