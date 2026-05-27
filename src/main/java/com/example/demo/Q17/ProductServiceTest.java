package com.example.demo.Q17;

package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository repo;
    @InjectMocks
    private ProductService service;
    @Test
    void testGetById() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");
        when(repo.findById(1L))
                .thenReturn(Optional.of(product));
        Product result = service.getById(1L);
        assertEquals("Laptop", result.getName());
    }
}
