package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.exeption.NotFoundException;
import ru.netology.products.Product;
import ru.netology.products.Book;
import ru.netology.products.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    private Product first = new Product(1, "чай", 150);
    private Book second = new Book(2, "Oracle", 560, "Бэн Форта");
    private Smartphone third = new Smartphone(3, "5C", 50000, "Appel");

    //ПРОВЕРКА УДАЛЕНИЕ - ID ЕСТЬ
    @Test
    void removeIdTrue() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(2);

        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{first, third};

        //проверка ожидаемого и фактического результата
        assertArrayEquals(expected, actual);
    }

    //ПРОВЕРКА УДАЛЕНИЕ - ID НЕТ ТАКОГО
    @Test
    void removeIdFalse() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });

    }

}

