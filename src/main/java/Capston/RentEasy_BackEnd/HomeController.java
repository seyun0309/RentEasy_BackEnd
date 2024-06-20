package Capston.RentEasy_BackEnd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String Home(){
        return "Hello World!";
    }
}
