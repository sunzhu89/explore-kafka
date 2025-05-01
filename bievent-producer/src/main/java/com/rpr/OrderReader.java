package com.rpr;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.List;
import java.util.stream.StreamSupport;

public class OrderReader {

    public static List<Order> getOrderList() {
        Yaml yaml = new Yaml(new Constructor(Order.class, new LoaderOptions()));
        InputStream inputStream = OrderReader.class.getClassLoader().getResourceAsStream("Orders.yaml");

        List<Order> orderList = StreamSupport.stream(yaml.loadAll(inputStream).spliterator(), false)
                .filter(Order.class::isInstance)
                .map(Order.class::cast)
                .toList();
        return orderList;
    }
}

