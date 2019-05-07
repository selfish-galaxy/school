package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.StaffService;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Staff;
import com.yyn.phone.consumer.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    /*
    查询所有，显示列表
     */
    @RequestMapping("/staffList1")
    public String staffList1(Model model){
        model.addAttribute("staffs",staffService.showAllStaffs());
        return "seller/staff";
    }

    /*
    去添加页
     */
    @RequestMapping("/toStaffAdd")
    public String toStaffAdd(){
        return "seller/staffAdd";
    }

    /*
    添加
     */
    @RequestMapping("addStaff")
    public String addStaff(Staff staff){
        staff.setSalary(staff.getBasic());
        staffService.addStaff(staff);
        return "redirect:staffList";
    }

    /*
   删除(真删除)
    */
    @RequestMapping("/delStaff")
    public String delStaff(Integer id){
        staffService.delStaff(id);
        return "redirect:staffList";
    }

    /*
    去修改页
     */
    @RequestMapping("/toUpdateStaff")
    public String toUpdateStaff(Integer id,Model model){
        model.addAttribute("staff",staffService.selectOneStaff(id));
        return "seller/staffUpdate";
    }

    /*
    修改
     */
    @RequestMapping("/updateStaff")
    public String updateStaff(Staff staff){
        staff.setSalary(staff.getBasic()+staff.getBonus());
        staffService.updateStaff(staff);
        return "redirect:staffList";
    }

    /*
    查询所有，显示列表（带分页）
     */
    @RequestMapping("/staffList")
    public String staffList(Integer currentPage, Integer size, Model model){
        if(currentPage == null){
            currentPage = 1;
        }
        if(size == null){
            size = 10;
        }
        PageBean<Staff> staffPageBean = staffService.staffPage(currentPage, size);
//        staffPageBean.pageView("staffList", params.toString());
        staffPageBean.pageView("staffList");
        model.addAttribute("staffs",staffPageBean);
        return "seller/staff";
    }

    @RequestMapping("/toStaffLogin")
    public String toStaffLogin(){
        return "seller/login";
    }

    @RequestMapping("/staffLogin")
    public String staffLogin(Model model, String stName, String stPwd, Integer id, HttpSession session){
        Boolean flag = staffService.staffLogin(stName, stPwd);
//        model.addAttribute("id",status);
        if (flag == true){
            // 设置session
            session.setAttribute(WebSecurityConfig.SESSION_KEY, stName);
//            session.setAttribute("sessionUser",session);
            Integer status = staffService.getStaffLoginStatus(stName, stPwd);
//            return "seller/index";
            return "redirect:menuList?id="+status;
        } else {
            return "seller/error";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        session.removeAttribute("menus");
        return "redirect:/";
    }

    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(HttpSession session){
//        Object attribute = session.getAttribute(WebSecurityConfig.SESSION_KEY);
//        String s = attribute.toString();
        return "seller/loginUpdate";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(HttpSession session, String stPwd){
        Object attribute = session.getAttribute(WebSecurityConfig.SESSION_KEY);
        String s = attribute.toString();
        staffService.updateStaffPassword(stPwd,s);
        return "redirect:toStaffLogin";
    }
}
