package servico.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
public class SampleController {

	@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public Message home() {
		return new Message("Hello, world!");
	}

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Messages messages() {
	    return new Messages(Arrays.asList(new Message("oi"),
                                          new Message("meu"),
                                          new Message("amigo")));
    }

    public class Messages {
        @JsonProperty
	    private final Collection<Message> messages;

        public Messages(Collection<Message> messages) {
            this.messages = messages;
        }

        public Collection<Message> getMessages() {
            return messages;
        }
    }

	public class Message {

        @JsonProperty
	    private String message;

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
