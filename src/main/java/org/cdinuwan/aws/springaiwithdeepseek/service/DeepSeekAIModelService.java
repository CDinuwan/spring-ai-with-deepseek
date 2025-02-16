package org.cdinuwan.aws.springaiwithdeepseek.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DeepSeekAIModelService {

    private final ChatClient chatClient;

    public DeepSeekAIModelService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String askToDeepSeekAI(String request) {
        return chatClient.prompt(request).call().content();
    }

    public Flux<String> askToDeepSeekAIWithStream(String question) {
        return chatClient.prompt(question).stream().content();
    }
}
