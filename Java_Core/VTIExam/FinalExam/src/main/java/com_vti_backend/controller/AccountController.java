package com_vti_backend.controller;

import com_vti_backend.sevice.IAccountService;
import com_vti_entity.Employee;
import com_vti_entity.Manager;
import com_vti_entity.Project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class AccountController {
    IAccountService iAccountService;
    List<Employee> employeeList = null;
    List<Manager> managerList = null;
    List<Project> projectList = null;
    // check mail and pass
    static boolean isValid_Mail(String mail) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return mail.matches(regex);
    }
    static boolean isValid_Pass(String pass){
        if (pass.length() < 6 || pass.length() > 12){
            return false;
        }else {
            for (int i =0;i<pass.length();i++){
                char c = pass.charAt(i);
                //check
                if(('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')){
                    return true;

                }else {
                    return false;
                }
            }
        }
        return true;
    }


    public AccountController(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    public void getList(int idPr) throws SQLException, IOException {
        int count = 0;
        projectList = iAccountService.getListId();
        if (projectList.isEmpty()){
            System.out.println("Khong co project nao");
        }else {
            for (Project elem : projectList){
                if (elem.getIdPr() == idPr) {
                    count ++;
                }
            }
        }
        if(count == 1){
            employeeList = iAccountService.getListEmp(idPr);
            managerList = iAccountService.getListManager(idPr);

            System.out.println("EMP:");
            if (employeeList.isEmpty()){
                System.out.println("Khong co nhan vien nao!");
            }else {
                for(Employee elem : employeeList){
                    System.out.println("ID: "+elem.getId()+"_"+"Name: "+elem.getFullName()+"_"+"ProSkill: " + elem.getProSkill() );
                }
            }
            System.out.println("Manager:");
            if(managerList.isEmpty()){
                System.out.println("Khong co quan ly nao");
            }else {
                for (Manager elem : managerList){
                    System.out.println("ID: "+ elem.getId()+"_"+"Name: "+elem.getFullName());
                }
            }
        }else {
            System.out.println("Khong co nhan vien va quan ly nao");
        }
    }

    public void getListManager() throws SQLException, IOException {
        managerList = iAccountService.getListManager();
        if(managerList.isEmpty()){
            System.out.println("Khong co quan ly nao");
        }else {
            for (Manager elem : managerList){
                System.out.println("ID: "+ elem.getId()+"_"+"Name: "+elem.getFullName()+"_"+"Exp: "+elem.getExpInYear());
            }
        }
    }

    public void Login(String mail, String pass) throws SQLException, IOException {
        if (isValid_Mail(mail) == false && isValid_Pass(pass) == false){
            System.out.println("Mail OR PassWord Malformed");
        }else{
            if(iAccountService.Login(mail,pass) == true){
                System.out.println("Dang nhap thanh cong");
            }else {
                System.out.println("Email va mat khau khong ton tai");
            }
        }
    }


}
