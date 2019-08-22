package todos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Todo {
    private @Id
    @GeneratedValue
    Long id;
    private String description;

    public Todo() {
    }

    public Todo(String description) {
        this.description = description;
    }
}
