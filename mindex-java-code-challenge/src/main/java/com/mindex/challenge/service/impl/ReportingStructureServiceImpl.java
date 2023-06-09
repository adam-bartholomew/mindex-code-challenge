package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
	
	@Autowired
    private EmployeeService employeeService;

	@Override
	public ReportingStructure read(String employeeId) {
		LOG.debug("Getting reportingStructure with employee id [{}]", employeeId);
		
		Employee employee = employeeService.read(employeeId);
        int totalReports = employeeService.getTotalNumberOfReports(employeeId);

        ReportingStructure reportingStructure = new ReportingStructure(employee, totalReports);

        return reportingStructure;
	}

}
