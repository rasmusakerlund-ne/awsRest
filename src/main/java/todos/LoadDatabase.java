package todos;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(TodoRepository todoRepository) {
        return args -> {
            todoRepository.save(new Todo("Check this into GitHub"));
            todoRepository.save(new Todo( "Make Pipeline"));

            todoRepository.findAll().forEach( todo -> {
                log.info("Saved: " + todo);
            });
        };
    }
}
