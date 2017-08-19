package br.blog.cbs.filter;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

@Service
public class FilterObjectService {

    public static <T>  T filter(T object, String fl) throws Exception {
      List<String> filterFieldName = getFilterFieldNames(fl);
      if (filterFieldName.size() == 1 && filterFieldName.get(0) == "*") {
          return object;
      }
      Class clazz = object.getClass();
      for (Field field : clazz.getDeclaredFields()){
          String fieldName = getFilterFieldName(field.getName());
          if (!filterFieldName.contains(fieldName)) {
              field.setAccessible(true);
              field.set(object, null);
          }
      }
      return object;
    }

    private static List<String> getFilterFieldNames(String fieldNames) {
        List<String> filterFieldNames = new LinkedList<>();
        for (String fieldName : fieldNames.split(",")) {
            filterFieldNames.add(getFilterFieldName(fieldName));
        }
        return filterFieldNames;
    }

    private static String getFilterFieldName(String fieldName) {
        return fieldName.toLowerCase().trim();
    }

}
