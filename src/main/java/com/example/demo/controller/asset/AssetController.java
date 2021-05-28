package com.example.demo.controller.asset;

import com.example.demo.config.SessionMember;
import com.example.demo.domain.asset.AssetVO;
import com.example.demo.service.asset.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@RequestMapping("/asset/")
//@RestController
@Controller
public class AssetController {

    @Autowired
    public AssetService service;

    @GetMapping("register") // localhost:8080/asset/register
    public String register(HttpSession httpSession, Model model) {

        SessionMember socialMember = (SessionMember) httpSession.getAttribute("socialMember");
        SessionMember loginMember = (SessionMember) httpSession.getAttribute("loginMember");

        if (socialMember != null) {
            model.addAttribute("member", socialMember);
        } else if(loginMember != null) {
            model.addAttribute("member", loginMember);
        }
        return "asset/register";

    }

    @PostMapping("register")
    public String register(String[] stock_name, String[] stock_price, String[] stock_count, String[] member_id, AssetVO assetVO) {

        for (int i = 0; i < stock_name.length; i++) { // a[i] b[i] c[i]
            assetVO.setStock_name(stock_name[i]);
            assetVO.setStock_price(stock_price[i]);
            assetVO.setStock_count(stock_count[i]);
            assetVO.setMember_id(member_id[i]);

            service.register(assetVO);
        }
        return "redirect:get";
    }

    @GetMapping("get")
    public String get(Model model, HttpSession httpSession) {
        SessionMember socialMember = (SessionMember) httpSession.getAttribute("socialMember");
        SessionMember loginMember = (SessionMember) httpSession.getAttribute("loginMember");

        if (socialMember != null) {
            model.addAttribute("asset", service.get(socialMember.getId()) );
        } else if(loginMember != null) {
            model.addAttribute("asset", service.get(loginMember.getId()) );
        }
//        System.out.println("-------------" + service.get(loginMember.getId()).getMember_id());

        return "asset/get";
    }

    @GetMapping("modify")
    public String modify(Model model, HttpSession httpSession) {

        SessionMember socialMember = (SessionMember) httpSession.getAttribute("socialMember");
        SessionMember loginMember = (SessionMember) httpSession.getAttribute("loginMember");

        if (socialMember != null) {
            model.addAttribute("asset", service.get(socialMember.getId()) );
        } else if(loginMember != null) {
            model.addAttribute("asset", service.get(loginMember.getId()) );
        }

        return "asset/modify";
    }

    @PostMapping("modify")
    public String modify(String[] stock_name, String[] stock_price, String[] stock_count, String[] asset_no, AssetVO assetVO){

        for (int i = 0; i < stock_name.length; i++) { // a[i] b[i] c[i]
            assetVO.setStock_name(stock_name[i]);
            assetVO.setStock_price(stock_price[i]);
            assetVO.setStock_count(stock_count[i]);
            long[] no = Arrays.stream(asset_no).mapToLong(Long::parseLong).toArray();
            assetVO.setAsset_no(no[i]);  //parse Long

            service.modify(assetVO);
        }
        return "redirect:get";
        }

    @PostMapping("remove")
    public String delete(Long asset_no){
        System.out.println("삭제된 번호" + asset_no );
        service.remove(asset_no);

        return "redirect:get";
    }



}
