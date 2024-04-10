package practice10.src.main.java.ru.mirea.practice10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice10.src.main.java.ru.mirea.practice10.programmers.Junior;
import practice10.src.main.java.ru.mirea.practice10.programmers.Middle;
import practice10.src.main.java.ru.mirea.practice10.programmers.Senior;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Junior junior = context.getBean(Junior.class);
        Middle middle = context.getBean(Middle.class);
        Senior senior = context.getBean(Senior.class);

        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
    }
}
