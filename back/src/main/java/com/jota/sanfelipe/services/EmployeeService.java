package com.jota.sanfelipe.services;

import com.jota.sanfelipe.entities.*;
import com.jota.sanfelipe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private AvalaibleServiceRepository avalaibleServiceRepository;

    @Autowired
    private WashedRepository washedRepository;

    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    private Date getStartDay(Date requestDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(requestDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    private Date getEndDay(Date requestDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(requestDate);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    private String getTimeOfDay(Date requestDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(requestDate);
        return String.format("%d:%02d",calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
    }
    public EmployeeCommissions getEmployeeCommissions(Long employee_id, Date request_date){

        Date startDay = getStartDay(request_date);
        Date endDay = getEndDay(request_date);

        List<Washed> washeds = washedRepository.findByDateBetweenAndEmployeeId( startDay, endDay, employee_id);
        List<EmployeeLabour> employeeLabours = new ArrayList<>();

        double totalCommissions = 0.0;
        for (Washed washed : washeds) {
            List<String> services = new ArrayList<>();
            List<Long> serviceIds = washed.getServices_id();

            Double services_price = 0.0;
            for (Long serviceId : serviceIds) {
                Optional<AvalaibleService> service = avalaibleServiceRepository.findById(serviceId);
                if (service.isPresent()) {
                    services.add(service.get().getName());
                    services_price += service.get().getPrice();
                    totalCommissions += service.get().getPrice();
                }
            }
            Optional<Client> client = clientRepository.findById(washed.getClient_id());
            Optional<Car> car = carRepository.findById((washed.getCar_id()));

            if (client.isPresent() && car.isPresent()) {
                EmployeeLabour employeeLabour = new EmployeeLabour(services, car.get().getLicencePlate(), client.get().getName() + " " + client.get().getLastName(), services_price, washed.getDate());
                employeeLabours.add(employeeLabour);
            }
        }
        return new EmployeeCommissions(
                employeeLabours,
                totalCommissions * 0.35 // 35% de comision
        );
    }

}
