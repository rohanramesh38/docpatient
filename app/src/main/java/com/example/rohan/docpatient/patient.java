package com.example.rohan.docpatient;

public class patient {

    private String namePatient;
    private String emailPatient;
    private String profilePic;
    private String des;
    private String nam;
    private String paNum;

    public String getPaNum() {
        return paNum;
    }

    public void setPaNum(String paNum) {
        this.paNum = paNum;
    }

    public patient() {

    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getEmailPatient() {
        return emailPatient;
    }

    public void setEmailPatient(String emailPatient) {
        this.emailPatient = emailPatient;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public patient(String namePatient, String emailPatient, String profilePic, String des, String nam,String paNum) {
        this.namePatient = namePatient;
        this.emailPatient = emailPatient;
        this.profilePic = profilePic;
        this.paNum=paNum;
        this.des = des;
        this.nam = nam;
    }

}
