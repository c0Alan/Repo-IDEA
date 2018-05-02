package com.springmvc.handler;

import com.springmvc.dao.DepartmentDao;
import com.springmvc.dao.EmployeeDao;
import com.springmvc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/demo2")
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id,
                            Map<String, Object> map) {
        if (id != null) {
            map.put("employee", employeeDao.get(id));
        }
    }

    /**
     * 自定义数据类型转换
     * @param employee
     * @return
     */
    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee") Employee employee) {
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        return "redirect:/demo2/emps";
    }

    /**
     * restful 增
     * @param employee
     * @param result
     * @param map
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(@Valid Employee employee, Errors result,
                       Map<String, Object> map) {
        System.out.println("save: " + employee);
        if (result.getErrorCount() > 0) {
            System.out.println("出错了!");
            for (FieldError error : result.getFieldErrors()) {
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }
            //若验证出错, 则转向定制的页面
            map.put("departments", departmentDao.getDepartments());
            return "input";
        }
        employeeDao.save(employee);
        return "redirect:/demo2/emps";
    }

    /**
     * restful 删
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/demo2/emps";
    }

    /**
     * restful 改
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String update(Employee employee) {
        employeeDao.save(employee);

        return "redirect:/demo2/emps";
    }

    /**
     * restful 查
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("employee", employeeDao.get(id));
        map.put("departments", departmentDao.getDepartments());
        return "input";
    }

    /**
     * GET 方法跳转
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String, Object> map) {
        map.put("employees", employeeDao.getAll());
        return "list";
    }

//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}

}