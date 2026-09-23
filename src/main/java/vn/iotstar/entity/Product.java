package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(
        nullable = false,
        length = 200,
        columnDefinition = "nvarchar(200)"
    )
    private String name;


    @Column(nullable = false)
    private BigDecimal price;


    @Column(length = 500)
    private String images;


    @Column(columnDefinition = "nvarchar(1000)")
    private String description;


    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;
}