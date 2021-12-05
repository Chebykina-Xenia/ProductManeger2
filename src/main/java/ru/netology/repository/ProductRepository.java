package ru.netology.repository;

import ru.netology.exeption.NotFoundException;
import ru.netology.products.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    //сохраняем продукты
    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    //выводим все продукты
    public Product[] findAll() {
        return items;
    }

    //определяем по id есть продукт в массиве или нет
    public boolean findById(int id) {
        findAll();
        int countTrue = 0;
        boolean byId = false;
        for (Product item : items) {
            if (item.getId() == id) {
                countTrue = countTrue + 1;
            }
        }
        if (countTrue == 1) {        //элемент по id есть в массиве, то возвращаем true
            return byId = true;
        } else {                    //иначе возвращаем false
            return byId = false;
        }
    }

    //удаляем по id
    public void removeById(int id) {
        if (findById(id) == false) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            int lenght = items.length - 1;
            Product[] tmp = new Product[lenght];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }
}
