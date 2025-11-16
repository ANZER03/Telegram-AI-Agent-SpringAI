package ma.enset.telegrambotaimcp.web;


import ma.enset.telegrambotaimcp.agents.Agent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AgentController {

    public Agent agent;

    public AgentController(Agent agent) {
        this.agent = agent;
    }

    @GetMapping(value = "/ask" , produces = MediaType.TEXT_PLAIN_VALUE)
    public String askAgent(String query, String id) {
        return this.agent.askAgent(query , id);
    }



}
