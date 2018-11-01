package pkg.app.service;

import org.springframework.stereotype.Service;

@Service
public class AppService {
    public String generateMessage() {
        return "one message from server";
    }
}
