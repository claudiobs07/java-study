package br.blog.cbs.objfilter;

import br.blog.cbs.reflection.ComparatorService;
import br.blog.cbs.reflection.Difference;
import br.blog.cbs.reflection.Person;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class ComparatorServiceTest extends TestCase {

    Person person1;
    Person person2;

    @Override
    protected void setUp() throws Exception {
        person1 = new Person("Claudio", "Santos", 24, "Programador");
        person2 = new Person("Claudio", "Santos", 24, "Programador");
    }

    @Test
    public void testCompareWhenEquals() throws Exception {
        List<Difference> differences = ComparatorService.compare(person1, person2);
        Assert.assertEquals(0, differences.size());
    }

    @Test
    public void testCompareWhenIncomparableFieldDifferent() throws Exception {
        person2.setSurname("Silva");
        List<Difference> differences = ComparatorService.compare(person1, person2);
        Assert.assertEquals(0, differences.size());
    }

    @Test
    public void testCompareWhenFieldDifferent() throws Exception {
        person2.setAge(28);
        List<Difference> differences = ComparatorService.compare(person1, person2);
        Assert.assertEquals(1, differences.size());
        Assert.assertEquals("age", differences.get(0).getField());
    }

}
