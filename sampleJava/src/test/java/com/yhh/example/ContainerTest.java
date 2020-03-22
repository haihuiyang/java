package com.yhh.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author happyfeet
 * @since Mar 11, 2020
 */
public class ContainerTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_get_when_no_element() {

        Container container = new Container(10);

        container.get(0);
    }

    @Test
    public void test_get() {

        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        Object result = container.get(2);

        Assert.assertEquals(2, result);
    }

    @Test
    public void test_get_first() {
        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        Object first = container.getFirst();

        Assert.assertEquals(0, first);
    }

    @Test
    public void test_get_first_when_no_first_value() {

        Container container = new Container(10);

        Assert.assertNull(container.getFirst());
    }

    @Test
    public void test_get_last_when_no_element() {

        Container container = new Container(10);

        Assert.assertNull(container.getLast());
    }

    @Test
    public void test_get_last() {

        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        Object last = container.getLast();

        Assert.assertEquals(5, last);

    }

    @Test
    public void test_put() {
        Container container = new Container(10);
        container.put(10);
        container.put(11);
        container.put(12);
        Assert.assertEquals(3, container.getSize());
        Assert.assertEquals(10, container.getFirst());
        Assert.assertEquals(12, container.getLast());
    }

    @Test
    public void test_put_when_need_resize_and_with_default_resize_factor() {

        Container container = new Container(2);
        container.put(10);
        container.put(11);
        container.put(12);

        Assert.assertEquals(4, container.getValues().length);
    }

    @Test
    public void test_put_when_need_resize_and_with_custom_resize_factor() {
        Container container = new Container(3, 2);
        container.put(10);
        container.put(11);
        container.put(12);

        Assert.assertEquals(6, container.getValues().length);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_update_when_index_is_less_than_zero() {

        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        container.update(-1, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_update_when_index_is_gt_size() {

        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        container.update(7, 10);
    }

    @Test
    public void test_update() {

        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        container.update(2, 10);

        Assert.assertEquals(10, container.get(2));
    }

    @Test
    public void delete() {
        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        Object delete = container.delete(3);

        Assert.assertEquals(3, delete);

        Object[] expect = {0, 1, 2, 4, 5};

        Assert.assertEquals(values.length - 1, container.getSize());

        Object[] newValues = container.getValues();

        for (int index = 0; index < expect.length; index++) {
            Assert.assertEquals(expect[index], newValues[index]);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_delete_when_index_is_less_than_zero() {

        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        container.delete(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_delete_when_index_is_gt_size() {

        Object[] values = {0, 1, 2, 3, 4, 5};

        Container container = new Container(values);

        container.delete(7);
    }
}
