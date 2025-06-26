/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.Account;
import com.Hi5Jobs.models.Application;
import com.Hi5Jobs.models.Employer;
import com.Hi5Jobs.models.Job;
import com.Hi5Jobs.models.Resume;
import java.time.LocalDate;
import com.Hi5Jobs.models.User;
import com.Hi5Jobs.services.AppUserService;
import com.Hi5Jobs.services.ApplicationService;
import com.Hi5Jobs.services.EmployeeService;
import com.Hi5Jobs.services.JobService;
import com.Hi5Jobs.services.LoginService;
import com.Hi5Jobs.services.ResumeService;
import com.Hi5Jobs.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LayoutPostController {

    @Autowired
    private JobService jobService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LoginService accountService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private AppUserService appuserService;
    @Autowired
    private ResumeService resumeService;

    @GetMapping("/post")
    public String show(HttpSession session, Model model, HttpServletResponse response) throws IOException {
        Integer accountId = (Integer) session.getAttribute("accountID");
        if (accountId != null) {
            User user = userService.findByAccountId(accountId); // tìm theo accountID
            if (user != null && user.getImg() != null) {
                String base64Image = Base64.getEncoder().encodeToString(user.getImg());
            }
            model.addAttribute("user", user);
        }
        Integer userType = (Integer) session.getAttribute("userType");
        if (userType == 3) {
            model.addAttribute("body", "/WEB-INF/views/client/postForm.jsp");
            return "client/layoutPost/main";
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(
                    "<script>alert('Tài khoản của bạn là Jobseeker. Vui lòng đăng ký tài khoản Employer để đăng tin.'); window.history.back();</script>");
            return null;
        }
    }

    @PostMapping("/post")
    public String add(@RequestParam("jobTitle") String jobTitle,
            @RequestParam("location") String location,
            @RequestParam("description") String description,
            @RequestParam("salaryType") String salaryType,
            @RequestParam("gender") String gender,
            @RequestParam("quantity") int quantity,
            @RequestParam("age") String age,
            @RequestParam("requirementNote") String requirementNote,
            @RequestParam("salaryFrom") String salaryFrom,
            @RequestParam("salaryTo") String salaryTo,
            HttpSession session,
            Model model,
            HttpServletResponse response) throws IOException {
        int accountID = (Integer) session.getAttribute("accountID");
        User user = userService.findByAccountId(accountID);
        Employer employer = employeeService.getByID(user.getUserID());
        if (employer == null
                || employer.getCompanyName() == null || employer.getCompanyName().isEmpty()
                || employer.getTaxcode() == null || employer.getTaxcode().isEmpty()) {

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<script>alert('Hãy cập nhật thông tin công ty trước khi đăng tuyển.'); window.history.back();   </script>");
            return null;
        }
        Job job = new Job();
        job.setUserID(user.getUserID());
        job.setTitle(jobTitle);
        job.setLocation(location);
        job.setDescriptionJob(description);
        job.setSalaryType(salaryType);
        job.setGentle(gender);
        job.setNumberofRecruiment(quantity);
        job.setAge(age);
        job.setRequirement(requirementNote);
        job.setSalary(salaryFrom + "-" + salaryTo);
        job.setUploadDate(LocalDate.now());
        job.setStatus(1);

        jobService.addNewJob(job);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script>alert('Đăng tuyển thành công.'); window.history.back();</script>");
        return null;
    }

    @RequestMapping("/settings")
    public String showSettingProfile(HttpSession session, Model model) {
        Integer accountId = (Integer) session.getAttribute("accountID");
        User user = userService.findByAccountId(accountId);
        session.setAttribute("userID", user.getUserID());
        model.addAttribute("user", user);
        Employer e = employeeService.getByID(user.getUserID());
        Account acc = accountService.getByAccountID(accountId);
        model.addAttribute("acc", acc);
        model.addAttribute("employee", e);
        model.addAttribute("body", "/WEB-INF/views/client/settings.jsp");
        return "client/layoutPost/main";
    }

    @RequestMapping("/update-profileRE")
    public String updateRE(@RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("address") String address,
            @RequestParam("avatar") MultipartFile avatar,
            @RequestParam("companyname") String conpanyname,
            @RequestParam("taxcode") String taxcode,
            @RequestParam("companydescription") String companydescription,
            @RequestParam("imageCompany") MultipartFile imageCompany,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Integer userId = (Integer) session.getAttribute("userID");
        if (userId == null) {
            return "redirect:/login";
        }

        byte[] imageBytes = null;
        try {
            if (!avatar.isEmpty()) {
                imageBytes = avatar.getBytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setUserID(userId);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setImg(imageBytes); // có thể null nếu người dùng không thay ảnh
        byte[] img = null;
        try {
            if (!imageCompany.isEmpty()) {
                img = imageCompany.getBytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        userService.updateUserInfo(user);
        Employer emp = new Employer();
        emp.setUserID(userId);
        emp.setCompanyName(conpanyname);
        emp.setCompanyDescription(companydescription);
        emp.setTaxcode(taxcode);
        emp.setImgCompany(img);

        employeeService.update(emp);
        return "redirect:/settings";
    }

    @RequestMapping("/change-password")
    public void changePass(@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass, HttpSession session, HttpServletResponse response) throws IOException {
        Integer accountId = (Integer) session.getAttribute("accountID");
        Account acc = accountService.getByAccountID(accountId);

        response.setContentType("text/html;charset=UTF-8");

        if (acc.getPassword().equals(oldpass)) {
            accountService.updatePassword(accountId, newpass);
            response.getWriter().write("<script>alert('✅ Cập nhật mật khẩu thành công!'); window.history.back();</script>");
        } else {
            response.getWriter().write("<script>alert('❌ Mật khẩu cũ không đúng!'); window.history.back();</script>");
        }
    }

    @GetMapping("/manage-applications")
    public String manageApplications(HttpSession session,
            @RequestParam(value = "jobID", required = false) Integer jobID,
            Model model) {
        Integer accountId = (Integer) session.getAttribute("accountID");
        User employer = userService.findByAccountId(accountId);

        // Danh sách job của employer
        List<Job> jobs = jobService.getAllJobsbyID(employer.getUserID());
        model.addAttribute("jobs", jobs);

        // Nếu có chọn jobID thì lọc application theo JobID
        List<Application> apps = applicationService.getApplicationsByJobID(jobID);

        model.addAttribute("applications", apps);
        model.addAttribute("selectedJobID", jobID); // giữ trạng thái lựa chọn
        model.addAttribute("body", "/WEB-INF/views/client/managecv.jsp");
        return "client/layoutPost/main";
    }

    @GetMapping("/manage-cv")
    public String s(HttpSession session,
            Model model) {
        Integer accountId = (Integer) session.getAttribute("accountID");
        User employer = userService.findByAccountId(accountId);

        // Danh sách job của employer
        List<Job> jobs = jobService.getAllJobsbyID(employer.getUserID());
        model.addAttribute("jobs", jobs);

        // giữ trạng thái lựa chọn
        model.addAttribute("body", "/WEB-INF/views/client/managecv.jsp");
        return "client/layoutPost/main";
    }


}
