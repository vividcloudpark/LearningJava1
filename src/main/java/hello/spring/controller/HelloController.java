package hello.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API방식 - StringhttpMessageConverter
    @GetMapping("hello-string")
    @ResponseBody //http의 바디에 직접 넣어주겠다
    public String HelloString(@RequestParam("name") String name){
        return name;
    }

    //API방식으로 ResponseBody로 return하면 json방식으로 객체를 바로 리턴한다. - MappingJackson2httpMessageConverter
    // json으로 바꿔주는 유명한 라이브러리가 Jackson. 
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }

}
