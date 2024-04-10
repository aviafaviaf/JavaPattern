package practice10.src.main.java.ru.mirea.practice10.programmers;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Junior coding...");
    }
}
