/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author lsayh
 */
//class chứa thông tin của người đăng nhập
public class ClassLoginInfo {

    private String Name;
    private int Role;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    public ClassLoginInfo() {
        this.Name = "";
        this.Role = 0;
    }

}
