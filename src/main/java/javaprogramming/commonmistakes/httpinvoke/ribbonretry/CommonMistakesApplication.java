package javaprogramming.commonmistakes.httpinvoke.ribbonretry;

import javaprogramming.commonmistakes.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {

        Utils.loadPropertySource(CommonMistakesApplication.class, "default-ribbon.properties");
        SpringApplication.run(CommonMistakesApplication.class, args);
    }
}

