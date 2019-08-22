package todos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    List<Todo> all() {
        return repository.findAll();
    }

    @PostMapping("/todos")
    Todo newTodo(@RequestBody Todo newTodo) {
        return repository.save(newTodo);
    }

    @PutMapping("/todos/{id}")
    Todo changeTodo(@RequestBody Todo newTodo, @PathVariable Long id) {
        return repository.findById(id).map(todo -> {
            todo.setDescription(newTodo.getDescription());
            return repository.save(todo);
        })
        .orElseGet(() -> {
            newTodo.setId(id);
            return repository.save(newTodo);
        });
    }

}
