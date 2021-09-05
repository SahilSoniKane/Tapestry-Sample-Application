package com.tapestry.dao;

import com.tapestry.entities.Employee;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee saveEmployee(Employee employee) {
        //entityManager.getEntityManagerFactory().unwrap(SessionFactory.class).getCurrentSession().saveOrUpdate(employee);
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("Select emp from Employee emp", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }
}
