package com.example.custom;

public class Employee {
    private String employeeName;
    private String employeeDescr;
    private int employeePhoto;

    private String phoneNumber;
    private String mail;

    public static Employee[] employees = {
            new Employee("Володько Наталья Игоревна", "Директор. \nСпециалист по таможенному декларированию 1 категории.", R.drawable.volodko, "tel:+375 44 580 31 66", "info@custom.by"),
            new Employee("Юрчик Олег Иванович", "Директор филиала Гродно.\nСпециалист по таможенному декларированию 1 категории", R.drawable.urchik, "tel:+375 44 580 82 96", "grodno@custom.by"),
            new Employee("Ахламов Евгений Геннадьевич", "Начальник отдела.\nСпециалист по таможенному декларированию 1 категории", R.drawable.achlamov, "tel:+375 29 616 74 02", "ahlamov@custom.by"),
            new Employee("Тенетко Татьяна Васильевна", "Начальник отдела.\nСпециалист по таможенному декларированию 1 категории", R.drawable.tenetko, "tel:+375 44 580 82 88", "445808288@custom.by"),
            new Employee("Халецкая Татьяна Николаевна", "Специалист по таможенному декларированию.", R.drawable.chaleckaya, "tel:+375 29 122 81 12", "291228112@custom.by"),
            new Employee("Кастрицкая Татьяна Анатольевна", "Специалист по таможенному декларированию 2 категории", R.drawable.kastrickaya, "tel:+375 44 544 54 55", "stat@custom.by"),
    };

    public Employee(String employeeName, String employeeDescr, int employeePhoto, String phoneNumber, String mail) {
        this.employeeName = employeeName;
        this.employeeDescr = employeeDescr;
        this.employeePhoto = employeePhoto;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeePhoto() {
        return employeePhoto;
    }

    public String getEmployeeDescr() {
        return employeeDescr;
    }

    @Override
    public String toString() {
        return employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }
}
