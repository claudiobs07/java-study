package br.blog.cbs.reflection;

import br.blog.cbs.objfilter.FilterObjectService;
import br.blog.cbs.objfilter.Car;
import junit.framework.TestCase;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;

public class FilterObjectTest extends TestCase {

    @Test
    public void testFilterWhenGetAll() throws Exception {
        Car car = new Car("Palio","FIAT","Azul","EEH-2913");
        Car carFiltered = FilterObjectService.filter(car, "*");
        Assert.assertEquals(car.toString(), carFiltered.toString());
    }

    @Test
    public void testFilterWhenFlEnrich() throws Exception {
        Car car = new Car("Palio","FIAT","Azul","EEH-2913");
        Car carFiltered = FilterObjectService.filter(SerializationUtils.clone(car), "licencePlate, brand");
        Assert.assertNotEquals(car.toString(), carFiltered.toString());
        Assert.assertEquals(car.getLicencePlate(),carFiltered.getLicencePlate());
        Assert.assertEquals(car.getBrand(),carFiltered.getBrand());
        Assert.assertNull(carFiltered.getName());
        Assert.assertNull(carFiltered.getColor());
    }

}
