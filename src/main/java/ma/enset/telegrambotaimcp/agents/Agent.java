package ma.enset.telegrambotaimcp.agents;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Component;

@Component
public class Agent {

    public ChatClient chatClient;

    public Agent (ChatClient.Builder chatClientBuilder,
                  ChatMemory chatMemory,
                  ToolCallbackProvider toolCallbackProvider) {

        this.chatClient = chatClientBuilder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    public String askAgent(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }

}
