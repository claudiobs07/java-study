package br.blog.cbs.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Person {

    private String name;
    @Incomparable
    private String surname;
    private int age;
    private String post;
}
