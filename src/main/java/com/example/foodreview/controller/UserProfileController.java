package com.example.foodreview.controller;

import com.example.foodreview.model.bean.APIResponse;
import com.example.foodreview.model.service.UserProfileRepository;
import com.example.foodreview.model.table.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping("/registor")
    public Object save(UserProfile userProfile){
        APIResponse res = new APIResponse();
        UserProfile userProfileDb = userProfileRepository.findByUserName(userProfile.getUserName());
        System.out.println(userProfile);
        if (userProfileDb == null){
            res.setStatus(0);
            res.setMessage("ลงทะเบียนเรียบร้อยแล้ว");
            userProfileRepository.save(userProfile);

        } else {
            res.setStatus(1);
            res.setMessage("มี Username นี้อยู่แล้ว");
        }
        return res;
    }

    @PostMapping("/login")
    public Object login(@RequestParam String username, @RequestParam String password){
        APIResponse res = new APIResponse();
        UserProfile userProfile = userProfileRepository.findByUserNameAndPassWord(username,password);
        if (userProfile == null){
            res.setStatus(1);
            res.setMessage("ไม่มีผู้ใช้");
        }else{
            res.setStatus(0);
            res.setMessage("เข้าสู่ระบบสำเร็จ");
            res.setData(userProfile.getId());

        }
        return res;
    }


}
