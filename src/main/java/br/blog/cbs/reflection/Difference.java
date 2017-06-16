package br.blog.cbs.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Difference {

    private String field;
    private Object object1;
    private Object object2;
}
