package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.StaffService;
import com.yyn.phone.consumer.service.UserService;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Staff;
import com.yyn.phone.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
