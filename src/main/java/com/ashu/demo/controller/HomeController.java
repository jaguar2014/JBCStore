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

@Controller
public class HomeController {

    @Autowired
    CosmeticsRepository cosmeticsRepository;
    @Autowired
    SnacksRepository snacksRepository;
    @Autowired
    CleaningItemsRepository cleaningItemsRepository;


    @GetMapping("/")
    public String showIndex() {
        return "inventoryindex";
    }

    @GetMapping("/addSnacks")
    public String addSnacks(Model model) {
        model.addAttribute("snack", new Snacks());


        return "snackform";

    }

    @PostMapping("/addSnacks")
    public String addSnacks(@Valid Snacks snack , BindingResult result) {

        if(result.hasErrors()){
            return "snackform";
        }
        snacksRepository.save(snack);


        return "inventoryindex";

    }

    @GetMapping("/addCosmetics")
    public String addCosmetics(Model model) {
        model.addAttribute("cosmetic", new Cosmetics());

        return "cosmeticform";

    }

    @PostMapping("/addCosmetics")
    public String addSnacks(@Valid Cosmetics cosmetic , BindingResult result) {

        if(result.hasErrors()){
            return "cosmeticform";
        }
        cosmeticsRepository.save(cosmetic);


        return "inventoryindex";

    }

 @GetMapping("/addCleaning")
    public String addCleaning(Model model) {
        model.addAttribute("cleaning", new CleaningItems());

        return "cleaningitemform";

    }

    @PostMapping("/addCleaning")
    public String addCleaString(@Valid CleaningItems cleaning , BindingResult result) {

        if(result.hasErrors()){
            return "cleaningitemform";
        }
        cleaningItemsRepository.save(cleaning);


        return "inventoryindex";

    }



}
