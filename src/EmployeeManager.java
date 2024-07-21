import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    static private ArrayList<Employee> employees = new ArrayList<Employee>();
    static private int countEmployee;
    static Scanner sc = new Scanner(System.in);
    private static int idAutoIncrease = 0;
    Certificate certificate = null;
    Employee employee = null;
    Employee employeesnew = null;

    public void downcasting(Employee employee) {
        if (employee instanceof Experience) {
            Experience experience = (Experience) employee;
            experience.ShowInfo();
        }
    }

    public static boolean isValidBirthDay(String birthDay) throws BirthDayException {
        if (birthDay == null || birthDay.isEmpty()) {
            throw new BirthDayException();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        String[] dateType = birthDay.split("/");
        int day = Integer.parseInt(dateType[0]);
        int month = Integer.parseInt(dateType[1]);
        int year = Integer.parseInt(dateType[2]);

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900) {
            throw new BirthDayException("Ngày sinh không hợp lệ. Xin vui lòng kiểm tra lại.");
        }
        if (month == 2 && day == 29) {
            if ((year % 4 != 0) || (year % 100 == 0 && year % 400 != 0)) {
                throw new BirthDayException("Năm không phải năm nhuận. Ngày sinh không hợp lệ.");
            }
        }
        return true;
    }

    public static boolean isValidPhone(String phone) throws PhoneException {
        String regex = "\\d{10}";
        if (phone == null || phone.isEmpty()) {
            throw new PhoneException();
        }

        if (!phone.matches(regex)) {
            throw new PhoneException("The phone number must be greater than 10 and less than 11 digits.");
        }
        return true;
    }

    public static boolean isValidEmail(String email) throws EmailException {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (email == null || email.isEmpty()) {
            throw new EmailException();
        }
        if (!email.matches(regex)) {
            throw new EmailException("Incorrect email format.");
        }
        return true;
    }

    public static boolean isValidFullName(String fullName) throws FullNameException {
        if (fullName == null || fullName.isEmpty()) {
            throw new FullNameException();
        }
        if (fullName.length() < 6) {
            throw new FullNameException("The name must be at least 6 characters long.");
        }
        return true;
    }

    public void addCertificate(Employee employee) {
        System.out.println("Khi vào làm bạn cần có bằng cấp nghề bạn có bao nhiêu bằng cấp?");
        int cer = sc.nextInt();
        if (cer < 1) {
            System.out.println("Cần có ít nhất 1 bằng cấp để đi làm");
            return;
        } else {
            for (int i = 1; i <= cer; i++) {
                System.out.println("chứng chỉ " + i);
                System.out.println("Nhập id chứng chỉ " + i);
                int certificatedID = i;
                sc.nextLine();
                System.out.println("Nhập tên chứng chỉ " + i);
                String certificatedName = sc.nextLine();
                System.out.println("Nhập rank chứng chỉ " + i);
                String certificatedRank = sc.nextLine();
                System.out.println("Nhập ngày cấp chứng chỉ " + i);
                String certificatedDate = sc.nextLine();
                certificate = new Certificate(certificatedID, certificatedName, certificatedRank, certificatedDate);
                employee.addCertificate(certificate);
            }
        }
    }

    public void addEmployee() {
        idAutoIncrease++;
        int id = idAutoIncrease;
        String birthDay = null, phone = null, fullName = null, email = null;
        boolean check = false;
        System.out.println("id: " + id);
        sc.nextLine();
        while (!check) {
            try {
                System.out.print("Nhập tên: ");
                fullName = sc.nextLine();
                isValidFullName(fullName);
                check = true;
            } catch (FullNameException e) {
                System.out.println(e.getMessage());
            }
        }
        check = false;
        while (!check) {
            try {
                System.out.print("Nhập Sinh nhật (dd/MM/yyyy): ");
                birthDay = sc.nextLine();
                isValidBirthDay(birthDay);
                check = true;
            } catch (BirthDayException e) {
                System.out.println(e.getMessage());
            }
        }
        check = false;
        while (!check) {
            try {
                System.out.print("Nhập sdt: ");
                phone = sc.nextLine();
                isValidPhone(phone);
                check = true;
            } catch (PhoneException e) {
                System.out.println(e.getMessage());
            }
        }
        check = false;
        while (!check) {
            try {
                System.out.print("Nhập email: ");
                email = sc.nextLine();
                isValidEmail(email);
                check = true;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Chọn level:");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Intern");
        int employeeType = sc.nextInt();
        sc.nextLine();

        if (employeeType == 1) {
            System.out.print("Nhập số năm kinh nghiệm: ");
            int expInYear = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhập kĩ năng chuyên môn: ");
            String proSkill = sc.nextLine();
            employee = new Experience(id, fullName, birthDay, phone, email, employeeType, expInYear, proSkill);
        } else if (employeeType == 2) {
            System.out.print("Nhập thời gian tốt nghiệp: ");
            String graduationDate = sc.nextLine();
            System.out.print("Nhập xếp loại tốt nghiệp: ");
            String graduationRank = sc.nextLine();
            System.out.print("Nhập trường tốt nghiệp: ");
            String education = sc.nextLine();
            employee = new Fresher(id, fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);
        } else if (employeeType == 3) {
            System.out.print("Nhập chuyên nghành học: ");
            String majors = sc.nextLine();
            System.out.print("Nhập kì đang học: ");
            int semester = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhập tên trường đang học: ");
            String universityName = sc.nextLine();
            employee = new Intern(id, fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
        }
        employees.add(employee);
        addCertificate(employee);
        countEmployee = employees.size();
        System.out.println("Thêm mới thành công");
        Employee.setEmployeeCount(Employee.getEmployeeCount() + 1);
        System.out.println("Số nhân viên hiện tại là:" + Employee.getEmployeeCount());
        employee.ShowInfo();
    }

    public void getAllEmployee() {
        System.out.println("Tổng số Employee là: " + countEmployee);
        downcasting(employee);
        System.out.println(employees);
    }

    public void removeEmployee() {
        System.out.println("Nhập id cần xoá");
        int id = sc.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                Employee.setEmployeeCount(Employee.getEmployeeCount() - 1);
                break;
            }
        }
        System.out.println(employees);
    }

    public void getEmployeeForType() {
        System.out.println("Bạn muốn lấy tất cả nhân viên nào?");
        System.out.println("1.Experience");
        System.out.println("2.Fresher");
        System.out.println("3.Intern");
        System.out.println("Số khác để chọn lại chức năng");
        int employeeType = sc.nextInt();
        if (employeeType == 1) {
            System.out.println("Tất cả Experience:");
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmployeeType() == employeeType) {
                    System.out.println(employees.get(i));
                }
            }
        } else if (employeeType == 2) {
            System.out.println("Tất cả Fresher:");
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmployeeType() == employeeType) {
                    System.out.println(employees.get(i));
                }
            }
        } else if (employeeType == 3) {
            System.out.println("Tất cả Intern:");
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmployeeType() == employeeType) {
                    System.out.println(employees.get(i));
                }
            }
        } else {
            System.out.println("bye!");
        }
    }

    public void updateEmployee() {
        System.out.println("Nhập id cần sửa");
        int idpdate = sc.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == idpdate) {
                updateEmployee(i);
                break;
            }
        }
    }

    public void updateEmployee(int i) {
        boolean check = false;
        sc.nextLine();
        String birthDay = null, fullName = null, phone = null, email = null;
        while (!check) {
            try {
                System.out.print("Nhập tên: ");
                fullName = sc.nextLine();
                isValidFullName(fullName);
                check = true;
            } catch (FullNameException e) {
                System.out.println(e.getMessage());
            }
        }
        check = false;
        while (!check) {
            try {
                System.out.print("Nhập Sinh nhật (dd/MM/yyyy): ");
                birthDay = sc.nextLine();
                isValidBirthDay(birthDay);
                check = true;
            } catch (BirthDayException e) {
                System.out.println(e.getMessage());
            }
        }
        check = false;
        while (!check) {
            try {
                System.out.print("Nhập sdt: ");
                phone = sc.nextLine();
                isValidPhone(phone);
                check = true;
            } catch (PhoneException e) {
                System.out.println(e.getMessage());
            }
        }
        check = false;
        while (!check) {
            try {
                System.out.print("Nhập email: ");
                email = sc.nextLine();
                isValidEmail(email);
                check = true;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Chọn level:");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Intern");
        System.out.print("Chọn loại: ");
        int employeeType = sc.nextInt();
        sc.nextLine();

        if (employeeType == 1) {
            System.out.print("Nhập số năm kinh nghiệm: ");
            int expInYear = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhập kĩ năng chuyên môn: ");
            String proSkill = sc.nextLine();
            employeesnew = new Experience(employees.get(i).getId(), fullName, birthDay, phone, email, employeeType, expInYear, proSkill);

        } else if (employeeType == 2) {
            System.out.print("Nhập thời gian tốt nghiệp: ");
            String graduationDate = sc.nextLine();
            System.out.print("Nhập xếp loại tốt nghiệp: ");
            String graduationRank = sc.nextLine();
            System.out.print("Nhập trường tốt nghiệp: ");
            String education = sc.nextLine();
            employeesnew = new Fresher(employees.get(i).getId(), fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);

        } else if (employeeType == 3) {
            System.out.print("Nhập chuyên nghành học: ");
            String majors = sc.nextLine();
            System.out.print("Nhập kì đang học: ");
            int semester = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhập tên trường đang học: ");
            String universityName = sc.nextLine();
            employeesnew = new Intern(employees.get(i).getId(), fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
        }
        System.out.println("Khi vào làm bạn cần có bằng cấp nghề bạn có bao nhiêu bằng cấp?");
        int cer = sc.nextInt();
        if (cer < 1) {
            System.out.println("Cần có ít nhất 1 bằng cấp để đi làm");
            return;
        } else {
            for (int j = 1; j <= cer; j++) {
                System.out.println("Nhập chứng chỉ " + j);
                System.out.println("Nhập id chứng chỉ " + j);
                int certificatedID = j;
                sc.nextLine();
                System.out.println("Nhập tên chứng chỉ " + j);
                String certificatedName = sc.nextLine();
                System.out.println("Nhập rank chứng chỉ " + j);
                String certificatedRank = sc.nextLine();
                System.out.println("Nhập ngày cấp chứng chỉ " + j);
                String certificatedDate = sc.nextLine();
                certificate = new Certificate(certificatedID, certificatedName, certificatedRank, certificatedDate);
                employeesnew.addCertificate(certificate);
            }
        }
        employees.remove(i);
        employees.add(employeesnew);
    }

    public void employeeLevelTop() {
        System.out.println("Các nhóm có thể update như sau");
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeType() == 2 || employees.get(i).getEmployeeType() == 3) {
                System.out.println(employees.get(i));
            }
        }
    }

    public void updateEmployeeType(int i) {
        System.out.println("Bạn muốn nâng cấp lên role nào");
        System.out.println("1.Fresher");
        System.out.println("2.Experience");
        int employeeType = sc.nextInt();
        if (employeeType == 1) {
            System.out.print("Nhập số năm kinh nghiệm: ");
            int expInYear = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhập kĩ năng chuyên môn: ");
            String proSkill = sc.nextLine();
            employeesnew = new Experience(employees.get(i).getId(), employees.get(i).getFullName(), employees.get(i).getBirthDay(), employees.get(i).getPhone(), employees.get(i).getEmail(), employeeType, expInYear, proSkill);
            for (int j = 0; j < employees.get(i).getCertificates().size(); j++) {
                employeesnew.addCertificate(employees.get(i).getCertificates().get(j));
            }
        } else if (employeeType == 2) {
            System.out.print("Nhập thời gian tốt nghiệp: ");
            String graduationDate = sc.nextLine();
            System.out.print("Nhập xếp loại tốt nghiệp: ");
            String graduationRank = sc.nextLine();
            System.out.print("Nhập trường tốt nghiệp: ");
            String education = sc.nextLine();
            employeesnew = new Fresher(employees.get(i).getId(), employees.get(i).getFullName(), employees.get(i).getBirthDay(), employees.get(i).getPhone(), employees.get(i).getEmail(), employeeType, graduationDate, graduationRank, education);
            for (int j = 0; j < employees.get(i).getCertificates().size(); j++) {
                employeesnew.addCertificate(employees.get(i).getCertificates().get(j));
            }
        }
        employees.remove(i);
        employees.add(employeesnew);
    }

    public void updateEmployeeType() {
        employeeLevelTop();
        System.out.println("Nhập id cần sửa");
        int idpdate = sc.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == idpdate) {
                updateEmployeeType(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int b = 0;
        boolean flag = true;
        EmployeeManager em = new EmployeeManager();
        do {
            System.out.println("Chon gi?: ");
            System.out.println("1.Thêm mới cán Employee\n"
                    + "2.Sửa Employee\n"
                    + "3.Xoá Employee\n"
                    + "4.Lấy Employee theo type\n"
                    + "5.Nâng cấp role cho employee\n"
                    + "Số khác để thoát.");
            b = sc.nextInt();
            switch (b) {
                case 1:
                    em.addEmployee();
                    break;
                case 2:
                    em.getAllEmployee();
                    em.updateEmployee();
                    break;
                case 3:
                    em.getAllEmployee();
                    em.removeEmployee();
                    break;
                case 4:
                    em.getEmployeeForType();
                    break;
                case 5:
                    em.updateEmployeeType();
                    break;
                default:
                    System.out.println("cook!!");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
