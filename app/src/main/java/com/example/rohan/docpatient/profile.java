package com.example.rohan.docpatient;

public class profile {
    private String name;
    private String email;
    private boolean permission;
    private String profilePic;
    private String des;
    private String nam;
    public profile(String name, String email, boolean permission, String profilePic,String des,String nam) {
        this.name = name;
        this.email = email;
        this.nam=nam;
        this.des=des;
        this.permission = permission;
        this.profilePic = profilePic;
    }

    public profile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
