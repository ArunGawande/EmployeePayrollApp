package com.blz.EmployeePayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);

        log.info("Employee Payroll App Startedin {} Environment....!!!",
                context.getEnvironment().getProperty("environment"));

    }

}