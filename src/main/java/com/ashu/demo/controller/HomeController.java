package com.ashu.demo.controller;

import com.ashu.demo.model.CleaningItems;
import com.ashu.demo.model.Cosmetics;
import com.ashu.demo.model.Snacks;
import com.ashu.demo.repository.CleaningItemsRepository;
import com.ashu.demo.repository.CosmeticsRepository;
import com.ashu.demo.repository.SnacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    CosmeticsRepository cosmeticsRepository;
    @Autowired
    SnacksRepository snacksRepository;
    @Autowired
    CleaningItemsRepository cleaningItemsRepository;

    public static double snackTotalPrice = 0.0;
    public static double cosmeticTotalPrice = 0.0;
    public static double cleaningTotalPrice = 0.0;
    public static long totalInventoryCount = 0;
    public static double totalInventoryPrice = 0.0;
    public static long cleaningTotalCount = 0;
    public static long cosmeticTotalCount=0;
    public static long snackTotalCount=0;

    @GetMapping("/")
    public String showIndex(Model model) {

        /*snackTotalCount = snacksRepository.count();

        Iterable<Snacks> allSnacks = snacksRepository.findAll();

        for (Snacks s :
                allSnacks) {
            snackTotalPrice += s.getPrice();
        }

        cosmeticTotalCount = cosmeticsRepository.count();

        Iterable<Cosmetics> allCosmetics = cosmeticsRepository.findAll();

        for (Cosmetics c :
                allCosmetics) {
            cosmeticTotalPrice += c.getPrice();
        }

        cleaningTotalCount = cleaningItemsRepository.count();

        Iterable<CleaningItems> allCleaning = cleaningItemsRepository.findAll();

        for (CleaningItems c :
                allCleaning) {
            cleaningTotalPrice += c.getPrice();
        }*/

        totalInventoryCount = snackTotalCount + cosmeticTotalCount + cleaningTotalCount;
        totalInventoryPrice = cosmeticTotalPrice + snackTotalPrice + cleaningTotalPrice;

        model.addAttribute("snackTotalCount", snackTotalCount);
        model.addAttribute("snackTotalPrice", snackTotalPrice);

        model.addAttribute("cosmeticTotalCount", cosmeticTotalCount);
        model.addAttribute("cosmeticTotalPrice", cosmeticTotalPrice);

        model.addAttribute("cleaningTotalPrice", cleaningTotalPrice);
        model.addAttribute("cleaningTotalCount", cleaningTotalCount);

        model.addAttribute("totalInventoryCount", totalInventoryCount);
        model.addAttribute("totalInventoryPrice", totalInventoryPrice);


        return "inventoryindex";
    }

    @GetMapping("/addSnacks")
    public String addSnacks(Model model) {
        model.addAttribute("snack", new Snacks());


        return "snackform";

    }

    @PostMapping("/addSnacks")
    public String addSnacks(@Valid Snacks snack, Model model, BindingResult result) {


        if (result.hasErrors()) {
            return "snackform";
        }
        snacksRepository.save(snack);

        snackTotalCount = snacksRepository.count();

        Iterable<Snacks> allSnacks = snacksRepository.findAll();

        for (Snacks s :
                allSnacks) {
            snackTotalPrice += s.getPrice();
        }


        model.addAttribute("snackTotalCount", snackTotalCount);
        model.addAttribute("snackTotalPrice", snackTotalPrice);

        return "redirect:/";


    }

    @GetMapping("/addCosmetics")
    public String addCosmetics(Model model) {
        model.addAttribute("cosmetic", new Cosmetics());

        return "cosmeticform";

    }

    @PostMapping("/addCosmetics")
    public String addSnacks(@Valid Cosmetics cosmetic, Model model, BindingResult result) {


        if (result.hasErrors()) {
            return "cosmeticform";
        }
        cosmeticsRepository.save(cosmetic);

        cosmeticTotalCount = cosmeticsRepository.count();

        Iterable<Cosmetics> allCosmetics = cosmeticsRepository.findAll();

        for (Cosmetics c :
                allCosmetics) {
            cosmeticTotalPrice += c.getPrice();
        }


        model.addAttribute("cosmeticTotalCount", cosmeticTotalCount);
        model.addAttribute("cosmeticTotalPrice", cosmeticTotalPrice);


        return "redirect:/";

    }

    @GetMapping("/addCleaning")
    public String addCleaning(Model model) {
        model.addAttribute("cleaning", new CleaningItems());

        return "cleaningitemform";

    }

    @PostMapping("/addCleaning")
    public String addCleaString(@Valid CleaningItems cleaning, Model model, BindingResult result) {


        if (result.hasErrors()) {
            return "cleaningitemform";
        }
        cleaningItemsRepository.save(cleaning);


        cleaningTotalCount = cleaningItemsRepository.count();

        Iterable<CleaningItems> allCleaning = cleaningItemsRepository.findAll();

        for (CleaningItems c :
                allCleaning) {
            cleaningTotalPrice += c.getPrice();
        }


        model.addAttribute("cleaningTotalPrice", cleaningTotalPrice);
        model.addAttribute("cleaningTotalPrice", cleaningTotalCount);

        return "redirect:/";

    }


}
