package com.blz.EmployeePayroll.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blz.EmployeePayroll.Dto.EmployeePayrollDto;
import com.blz.EmployeePayroll.Model.EmployeePayrollModel;
import com.blz.EmployeePayroll.Service.IEmployeePayrollService;
import com.blz.EmployeePayroll.Util.Response;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @PostMapping("/create")
    public EmployeePayrollModel create(@Valid @RequestBody EmployeePayrollDto emp ,@RequestParam Long department_id ) {
        return employeePayrollService.createEmp(emp,department_id);
    }

    @GetMapping("/getlist")
    public List<EmployeePayrollModel> getList() {
        return employeePayrollService.getList();
    }

    @PostMapping("/login")
    public Response login(@RequestParam String mail,@RequestParam String pwd) {
        return employeePayrollService.login(mail,pwd);
    }

    @GetMapping("/sortbyfirstname")
    public List<EmployeePayrollModel> sort(@PathVariable String content){
        return employeePayrollService.getByContent(content);
    }


    @GetMapping("/getempbytoken")
    public EmployeePayrollModel getEmpByToken(@RequestHeader String token){
        return employeePayrollService.getEmpByToken(token);
    }

    @GetMapping("/getempwithid/{id}")
    public EmployeePayrollModel getEmployee(@PathVariable long id) {
        return employeePayrollService.getEmployeeById(id);
    }

    @GetMapping("/sendmail/{id}")
    public void sendMail(@PathVariable long id) {
        employeePayrollService.sendMail(id);

    }


//	@PutMapping("/update/{id}")
//	public EmployeePayrollModel update(@RequestBody EmployeePayrollModel emp, @PathVariable long id) {
//		return employeePayrollService.update(emp, id);
//
//	}

    @PutMapping("/update/{empId}")
    public EmployeePayrollModel updateDepartment(@RequestBody EmployeePayrollDto emp, @PathVariable long empId,@RequestParam long deptId) {
        return employeePayrollService.update(emp, empId,deptId);

    }

    @PutMapping("/updatedepartmentwithtoken")
    public EmployeePayrollModel updateDepartmentWithToken(@RequestBody EmployeePayrollDto emp, @RequestHeader String token,@RequestParam long deptId) {
        return employeePayrollService.updateDepartmentWithToken(emp, token,deptId);

    }


    @PutMapping("/updatewithtoken")
    public EmployeePayrollModel updateWithToken(@RequestHeader String token) {
        return employeePayrollService.updateWithToken(token);

    }

    @DeleteMapping("/delete/{id}")
    public EmployeePayrollModel delete(@PathVariable long id) {
        return employeePayrollService.delete(id);

    }

    @DeleteMapping("/deletewithtoken")
    public EmployeePayrollModel deleteWithToken(@RequestHeader String token) {
        return employeePayrollService.deleteWithToken(token);

    }


}