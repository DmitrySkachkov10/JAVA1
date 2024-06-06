package by.dmitry_skachoku.BeanPostProcessor.quoters;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
@Profoling
public class TerminationQuoter implements Quoter {

    @InjectRandomInt(min = 4, max = 8)
    private int repeat;

    @PostConstruct
    public void init() {
        System.out.println("phase 2 = " + repeat);
    }

    public TerminationQuoter() {
        System.out.printf("phase 1 " + repeat);
    }

    private String message = "HI";

    @Override
    public void sayQuoter() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
