package vn.iotstar.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import vn.iotstar.dto.CategoryDTO;
import vn.iotstar.service.CategoryService;


@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;



    @GetMapping
    public String list(Model model){

        model.addAttribute(
                "categories",
                categoryService.findAll()
        );

        return "categories/list";
    }



    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute(
                "category",
                new CategoryDTO()
        );

        return "categories/form";
    }



    @PostMapping("/save")
    public String save(
            @ModelAttribute CategoryDTO category
    ){

        categoryService.save(category);

        return "redirect:/categories";
    }




    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model
    ){

        model.addAttribute(
                "category",
                categoryService.findById(id)
        );


        return "categories/form";
    }




    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ){

        categoryService.delete(id);

        return "redirect:/categories";
    }

}