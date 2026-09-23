package vn.iotstar.service;

import java.util.List;

import vn.iotstar.dto.CategoryDTO;

public interface CategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO findById(Long id);

    CategoryDTO save(CategoryDTO dto);

    void delete(Long id);
}