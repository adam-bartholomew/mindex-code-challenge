package com.mindex.challenge.data;

import java.util.Date;

public class Compensation {
	private String employeeId;
    private String salary;
    private Date effectiveDate;
    
    public Compensation() {	
    }
    
    public String getEmployeeId() {
    	return this.employeeId;
    }
    
    public String getSalary() {
    	return this.salary;
    }
    
    public Date getEffectiveDate() {
    	return this.effectiveDate;
    }
    
    public void setEmployeeId(String employeeId) {
    	this.employeeId = employeeId;
    }
    
    public void setSalary(String salary) {
    	this.salary = salary;
    }
    
    public void setEffectiveDate(Date effectiveDate) {
    	this.effectiveDate = effectiveDate;
    }
}
