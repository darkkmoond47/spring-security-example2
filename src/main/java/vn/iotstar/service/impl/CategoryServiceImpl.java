package vn.iotstar.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import vn.iotstar.dto.CategoryDTO;
import vn.iotstar.entity.Category;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.service.CategoryService;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;


    @Override
    public List<CategoryDTO> findAll() {

        return categoryRepository.findAll()
                .stream()
                .map(c -> new CategoryDTO(
                        c.getId(),
                        c.getName(),
                        c.getImages(),
                        c.isEnabled()
                ))
                .toList();
    }


    @Override
    public CategoryDTO findById(Long id) {

        Category c = categoryRepository.findById(id)
                .orElseThrow();

        return new CategoryDTO(
                c.getId(),
                c.getName(),
                c.getImages(),
                c.isEnabled()
        );
    }


    @Override
    public CategoryDTO save(CategoryDTO dto) {


        Category c;


        if(dto.getId()!=null){

            c = categoryRepository.findById(dto.getId())
                    .orElseThrow();

        }else{

            c = new Category();

        }


        c.setName(dto.getName());
        c.setImages(dto.getImages());
        c.setEnabled(dto.isEnabled());


        Category save = categoryRepository.save(c);


        return new CategoryDTO(
                save.getId(),
                save.getName(),
                save.getImages(),
                save.isEnabled()
        );
    }


    @Override
    public void delete(Long id){

        categoryRepository.deleteById(id);

    }
}