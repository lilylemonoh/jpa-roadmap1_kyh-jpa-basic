package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class BookExample extends ItemExample {
    private String author;
    private String isbn;
}
