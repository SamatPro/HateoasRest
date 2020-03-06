package ru.itis.hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.hateoas.utils.InitializerUtil;

@SpringBootApplication
public class HateoasApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HateoasApplication.class, args);

        InitializerUtil.init(context);

    }

}
