package com.example.transport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Впишите марку")
    private String brand;
    @NotBlank(message = "Впишите модель")
    private String model;
    @NotBlank(message = "Впишите категорию")
    private String category;
    @NotBlank(message = "Впишите государственный номер")
    @Pattern(regexp = ".{6}", message = "Государственный номер записан некорректно")
    @Column(unique = true)
    private String licenseNumber;
    @NotBlank(message = "Выберите тип транспорта")
    private String type;
    @NotNull(message = "Впишите год выпуска")
    @Min(value = 0, message = "Год не может быть отрицательным")
    private Integer releaseYear;
    private Boolean hasTrailer;

}
