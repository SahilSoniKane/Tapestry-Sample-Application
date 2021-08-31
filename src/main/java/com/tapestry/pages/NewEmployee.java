package com.tapestry.pages;

import com.tapestry.entities.Employee;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextArea;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;

public class NewEmployee extends EmployeeList{

    @Inject
    private AlertManager alertManager;

    @InjectComponent("inputs")
    private Form inputs;

    @InjectComponent("name")
    private TextField nameField;

    @InjectComponent("age")
    private TextField ageField;

    @InjectComponent("address")
    private TextArea addressArea;

    @Property
    private String name;

    @Property
    private int age;

    @Property
    private String address;

    @InjectPage
    private EmployeeDetails employeeDetails;

    @InjectPage
    private EmployeeList employeeList;

    @Property
    private int id;

    void onValidateFromInputs() {
        for (int i = 0; i < name.length(); i++) {
            if ((int)name.charAt(i) > 0 & (int)name.charAt(i) < 48 || (int)name.charAt(i) > 57 & (int)name.charAt(i) < 65 || (int)name.charAt(i) > 90 & (int)name.charAt(i) < 97 || (int)name.charAt(i) > 122 & (int)name.charAt(i) < 128)
                inputs.recordError(nameField, "Name can only contain AlphaNumeric only");
        }

        if (age < 18 | age > 65)
            inputs.recordError(ageField, "Age should be between 18-65");
    }

    Object onSuccessFromInputs() {
        alertManager.success("Saved Successfully");
        if (!employeeList.listOfEmployees.isEmpty()) {
            for (Employee employee : employeeList.listOfEmployees) {
                if (this.id <= employee.getId())
                    this.id++;
            }
                employeeList.addEmployee(this.id, this.name, this.age, this.address);
        }
        else {
            employeeList.addEmployee(this.id, this.name, this.age, this.address);
        }
        employeeDetails.set(id, name, age, address);

        return EmployeeDetails.class;
    }

    void onFailureFromInputs() {
        alertManager.error("Couldn't Save Employee!! Please try again");
    }
}
