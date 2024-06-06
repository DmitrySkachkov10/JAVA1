package by.dmitry_skachoku.BeanPostProcessor;

import by.dmitry_skachoku.BeanPostProcessor.quoters.TerminationQuoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanPostProcessorApplication implements CommandLineRunner {

    @Autowired
    private TerminationQuoter quoter;

    public static void main(String[] args) {
        SpringApplication.run(BeanPostProcessorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        quoter.sayQuoter();
    }
}
