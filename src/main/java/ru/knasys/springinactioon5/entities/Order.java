package ru.knasys.springinactioon5.entities;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Заполните поле Имя")
    private String name;
    @NotBlank(message = "Заполните поле Улица")
    private String street;
    @NotBlank(message = "Заполните поле Город")
    private String city;
    @NotBlank(message = "Заполните поле Область/Край")
    private String state;
    @NotBlank(message = "Заполните поле Индекс")
    private String zip;
    @CreditCardNumber(message = "Номер карты не верный")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/]([1-9][0-9]))$", message = "Действует до должно быть в формате ММ/ГГ")
    private String ccExpiration;
//    @Digits(integer = 3, fraction = 0, message = "CVV не верный")
    @Pattern(regexp = "^\\d{3}$", message = "CVV не верный")
    private String ccCVV;

    private Date placedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    private final List<Taco> tacos = new ArrayList<>();

    @PrePersist
    private void placeAt(){
        placedAt = new Date();
    }
}
