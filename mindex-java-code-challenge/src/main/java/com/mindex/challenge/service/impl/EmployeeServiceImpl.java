package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

	@Override
	public int getTotalNumberOfReports(String employeeId) {
		LOG.debug("Getting total number of reports for employee id [{}]", employeeId);
		
		int directReports = 0;
		Employee employee = read(employeeId);
		
        if(employee == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        }
        
        // Add 1 for each employee that reports to the current employee (children) and any employee who reports to them (grand children).
        if(employee.getDirectReports() != null) {
        	for(Employee e : employee.getDirectReports()) {
        		directReports += 1; // Add 1 for each direct report (children)
        		directReports += getTotalNumberOfReports(e.getEmployeeId()); // Add all grand children
    		}
        }
		return directReports;
	}
}
