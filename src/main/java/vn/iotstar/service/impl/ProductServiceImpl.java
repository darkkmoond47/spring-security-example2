package vn.iotstar.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.dto.ProductDTO;
import vn.iotstar.entity.Product;
import vn.iotstar.mapper.ProductMapper;
import vn.iotstar.repository.ProductRepository;
import vn.iotstar.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public Page<ProductDTO> findAll(
            String keyword,
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> products;

        if (keyword != null && !keyword.isEmpty()) {

            products = productRepository
                    .findByNameContainingIgnoreCase(
                            keyword,
                            pageable
                    );

        } else {

            products = productRepository.findAll(pageable);

        }


        return products.map(productMapper::toDTO);
    }


    @Override
    public ProductDTO findById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow();

        return productMapper.toDTO(product);
    }


    @Override
    public ProductDTO save(ProductDTO dto) {

        Product product;

        if (dto.getId() != null) {

            product = productRepository.findById(dto.getId())
                    .orElseThrow();

        } else {

            product = new Product();

        }


        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setImages(dto.getImages());
        product.setDescription(dto.getDescription());
        product.setEnabled(dto.isEnabled());


        return productMapper.toDTO(
                productRepository.save(product)
        );
    }


    @Override
    public void delete(Long id) {

        productRepository.deleteById(id);

    }
}