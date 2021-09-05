package com.tapestry.pages;

import com.tapestry.entities.Employee;
import com.tapestry.services.EmployeeService;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextArea;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import java.util.regex.Pattern;

public class NewEmployee {

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
    private int id;

    @Property
    private String name;

    @Property
    private int age;

    @Property
    private String address;

    @InjectPage
    private EmployeeDetails employeeDetails;

    @Inject
    private PageRenderLinkSource pageRenderLinkSource;

    @Inject
    private EmployeeService employeeService;

    void onValidateFromInputs() {
        String regex = "^[a-zA-Z\\s]*$";
        if (!Pattern.compile(regex).matcher(name).matches())
            inputs.recordError(nameField, "Name can only contain AlphaNumeric only");
        if (age < 18 || age > 65)
            inputs.recordError(ageField, "Age should be between 18-65");
    }

    Object onSuccessFromInputs() {
        alertManager.success("Saved Successfully");
        Employee employee = employeeService.saveEmployee(new Employee(name, age, address));
        return this.pageRenderLinkSource.createPageRenderLinkWithContext(EmployeeDetails.class, employee.getId());
    }

    void onFailureFromInputs() {
        alertManager.error("Couldn't Save Employee!! Please try again");
    }
}
