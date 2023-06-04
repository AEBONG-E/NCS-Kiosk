package com.kobuks.kiosk.admin.service;


import com.kobuks.kiosk.admin.domain.Admin;

import java.util.List;

public interface AdminService {

    Admin getAdmin(String id, String password);
    List<Admin> selectAllAdmins();

}
