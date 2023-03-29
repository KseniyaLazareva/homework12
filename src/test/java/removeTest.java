import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class removeTest {

    @Test
    public void existingIdRemove() {

        Product product1 = new Product(155233, "Книга", 200);
        Product product2 = new Product(133233, "Тетрадь", 200);
        Product product3 = new Product(144233, "Ручка", 200);

        ShopRepository shopRepository = new ShopRepository();

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        shopRepository.remove(144233);

        Product[] expected = {product1, product2};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void nonExistingIdRemove() {

        Product product1 = new Product(155233, "Книга", 200);
        Product product2 = new Product(133233, "Тетрадь", 200);
        Product product3 = new Product(144233, "Ручка", 200);

        ShopRepository shopRepository = new ShopRepository();

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(154233);
        });
    }


}
