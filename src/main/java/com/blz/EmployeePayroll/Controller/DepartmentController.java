package com.blz.EmployeePayroll.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blz.EmployeePayroll.Dto.DepartmentDto;
import com.blz.EmployeePayroll.Model.Department;
import com.blz.EmployeePayroll.Service.IDepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    IDepartmentService departmentService;

    @GetMapping("/getdepartments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @PostMapping("adddepartment")
    public Department addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.addDepartment(departmentDto);
    }

    @GetMapping("/getdepartmentbytoken")
    public Department getDepartmentByToken(@RequestHeader String token) {
        return departmentService.getDepartmentByToken(token);
    }
}