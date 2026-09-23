package vn.iotstar.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.iotstar.dto.ProductDTO;
import vn.iotstar.service.ProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public String list(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            Model model
    ) {

        model.addAttribute(
                "products",
                productService.findAll(
                        keyword,
                        page,
                        5
                )
        );

        model.addAttribute(
                "keyword",
                keyword
        );

        return "products/list";
    }


    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute(
                "product",
                new ProductDTO()
        );

        return "products/form";
    }


    @PostMapping("/save")
    public String save(
            @ModelAttribute ProductDTO product
    ) {

        productService.save(product);

        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ) {

        productService.delete(id);

        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model
    ) {

        model.addAttribute(
                "product",
                productService.findById(id)
        );

        return "products/form";
    }


    @PostMapping("/update")
    public String update(
            @ModelAttribute ProductDTO product
    ) {

        productService.save(product);

        return "redirect:/products";
    }
}