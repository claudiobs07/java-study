package br.blog.cbs.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
public class Car implements Serializable {

    private String name;
    private String brand;
    private String color;
    private String licencePlate;

}
