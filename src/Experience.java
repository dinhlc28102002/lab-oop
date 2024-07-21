public class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public Experience(int id, String fullName, String birthDay, String phone, String email, int employeeType, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }


    public int getExpInYear() {
        return expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }


    @Override
    public void ShowInfo() {
        System.out.println("Experience \n" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
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
