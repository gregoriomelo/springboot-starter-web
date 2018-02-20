package servico.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@RequestMapping("/hello")
	@ResponseBody
	public Message home() {
		return new Message("Hello, world!");
	}

	class Message {
	    private String message;

        public Message(String message) {
            this.message = message;
        }

        @JsonProperty
        public String getMessage() {
            return message;
        }
    }
}
