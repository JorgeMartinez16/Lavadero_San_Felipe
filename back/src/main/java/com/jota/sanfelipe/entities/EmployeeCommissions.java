package com.jota.sanfelipe.entities;

import java.util.List;

public class EmployeeCommissions {
    private List<EmployeeLabour> employeeLabours;
    private Double total_commissions;

    public EmployeeCommissions(List<EmployeeLabour> employeeLabours, Double total_commissions) {
        this.employeeLabours = employeeLabours;
        this.total_commissions = total_commissions;
    }

    public List<EmployeeLabour> getEmployeeLabours() {
        return employeeLabours;
    }

    public void setEmployeeLabours(List<EmployeeLabour> employeeLabours) {
        this.employeeLabours = employeeLabours;
    }

    public Double getTotal_commissions() {
        return total_commissions;
    }

    public void setTotal_commissions(Double total_commissions) {
        this.total_commissions = total_commissions;
    }


}
