public class Intern extends Employee {
    private String majors;
    private int semester;
    private String universityName;

    public Intern(int id, String fullName, String birthDay, String phone, String email, int employeeType, String majors, int semester, String universityName) {
        super(id, fullName, birthDay, phone, email, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public int getSemester() {
        return semester;
    }

    public String getUniversity_name() {
        return universityName;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setUniversity_name(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void ShowInfo() {
        System.out.println("Intern \n" +
                "majors='" + majors + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
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
