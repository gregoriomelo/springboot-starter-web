package servico.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/messages")
public class SampleController {

	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message home() {
		return new Message("Hello, world!");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Messages messages() {
	    return new Messages(Arrays.asList(new Message("oi"),
                                          new Message("meu"),
                                          new Message("amigo")));
    }

    public class Messages {
	    private final Collection<Message> messages;

        public Messages(Collection<Message> messages) {
            this.messages = messages;
        }

        public Collection<Message> getMessages() {
            return messages;
        }
    }

	public class Message {
	    private String message;

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
