package com.all.pdv.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo descrição é obrigatório!")
    private String description;

    @Column(length = 20, precision = 20, scale = 2, nullable = false)
    @NotNull(message = "O campo price é obrigatório!")
    private BigDecimal price;

    @Column(nullable = true)
    @NotNull(message = "O campo quantity é obrigatório!")
    private int quantity;
}
