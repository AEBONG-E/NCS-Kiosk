package com.kobuks.kiosk.admin.service;

import com.kobuks.kiosk.admin.dao.AdminDao;
import com.kobuks.kiosk.admin.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getAdmin(String id, String password) {
        return adminDao.selectAdminByIdAndPassword(id, password);
    }

    @Override
    public List<Admin> selectAllAdmins() {
        return adminDao.selectAllAdmins();
    }

}
