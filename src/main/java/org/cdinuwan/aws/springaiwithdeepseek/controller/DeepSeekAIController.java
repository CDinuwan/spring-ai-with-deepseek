package org.cdinuwan.aws.springaiwithdeepseek.controller;

import org.cdinuwan.aws.springaiwithdeepseek.service.DeepSeekAIModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/ai")
public class DeepSeekAIController {

    @Autowired
    private DeepSeekAIModelService deepSeekAIModel;

    private static Logger LOG = LoggerFactory.getLogger(DeepSeekAIController.class);

    @GetMapping("/prompt")
    public String askFromAI(@RequestParam(value = "question") String question) {
        try {
            return deepSeekAIModel.askToDeepSeekAI(question);
        } catch (Exception e) {
            LOG.error("There is an error with deep seek AI. Please try again it later");
        }
        return "Error occured while processing the re      quest";
    }

    @GetMapping("/promptAsync")
    public Flux<String> askFromAIAsync(@RequestParam(value = "question") String question) {
        return deepSeekAIModel.askToDeepSeekAIWithStream(question);
    }
}
