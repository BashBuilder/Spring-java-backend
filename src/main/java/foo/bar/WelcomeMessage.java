package foo.bar;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

    public String getMessage() {
        System.out.println("Welcome to this new spring application");
        return "Hello, World!";
    }
}
