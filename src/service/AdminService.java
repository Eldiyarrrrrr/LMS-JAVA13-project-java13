package service;

import group.Admin;

public interface AdminService {

    Admin login(Admin admin);

    Admin changePassword(Admin admin);
}
