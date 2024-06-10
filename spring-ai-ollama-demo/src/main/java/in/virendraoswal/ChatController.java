package in.virendraoswal;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ChatController {

	private final ChatClient chatClient;

	public ChatController(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.build();
	}

	@PostMapping("/generate")
	String generation(@RequestBody String input) {
		return this.chatClient.prompt().user(input).call().content();
	}
}