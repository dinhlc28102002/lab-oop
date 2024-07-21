public class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(int id, String fullName, String birthDay, String phone, String email, int employeeType, String graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void ShowInfo() {
        System.out.println("Fresher \n" +
                "graduationDate='" + graduationDate + '\'' +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
                ", id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", birthDay='" + getBirthDay() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", employee_type='" + getEmployeeType() + '\'');

        for (Certificate certificate: getCertificates()) {
            System.out.println(certificate.toString());
        }
    }
}
