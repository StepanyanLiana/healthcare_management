package com.example.healthcare_management.controller;

import com.example.healthcare_management.security.CurrentUser;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class MainController {
    @Value("${healthcare_management.upload.image.path}")
    private String imageUploadPath;

    @GetMapping("/")
    public String main(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        // Object currentUserObj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //  if (currentUserObj instanceof CurrentUser) {
        //  CurrentUser currentUser = (CurrentUser) currentUserObj;
        if (currentUser != null) {
            modelMap.addAttribute("user", currentUser.getUser());
        }
     return "index";
    }

    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("image") String profilePic) throws IOException {
        File file = new File(imageUploadPath + profilePic);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            return IOUtils.toByteArray(fis);
        }
        return null;
    }
}
