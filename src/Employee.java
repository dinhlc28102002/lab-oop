import java.util.ArrayList;

public abstract class Employee {
    private int id;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private int employeeType;

    private static int employeeCount = 0;

    private ArrayList<Certificate> certificates;

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
    }

    public ArrayList<Certificate> getCertificates() {
        return certificates;
    }

    public Employee(int id, String fullName, String birthDay, String phone, String email, int employeeType) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.certificates = new ArrayList<>();
    }

    public Employee() {

    }

    public abstract void ShowInfo();

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
