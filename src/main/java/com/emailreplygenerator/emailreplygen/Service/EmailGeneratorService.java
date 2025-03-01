package com.emailreplygenerator.emailreplygen.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.emailreplygenerator.emailreplygen.Model.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String generateEmailReply(EmailRequest emailRequest){
             //Building the prompt
             String prompt = buildPrompt(emailRequest);
             //Craft the req
        Map<String, Object> req = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );
             //Make the req
       String response = webClient.post()
               .uri(geminiApiUrl + geminiApiKey)
               .header("Content-Type","application/json")
               .bodyValue(req)
               .retrieve()
               .bodyToMono(String.class)
               .block();
             //Extract and Return the response
        return extractResponseContent(response);

    }

    private String extractResponseContent(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();//Convert Json data -> Java Objects and vice versa
            JsonNode rootNode = mapper.readTree(response);//readTree -> converts the entire response into a tree like structure which is stored in JsonTree
            return rootNode.path("candidates") //check the response string in postman to understand this
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText(); //converting the extracted text to String
        } catch (Exception e) {
            return "Error processing request : "+e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt  = new StringBuilder();
        prompt.append("Generate an email reply for the following email. Please don't give subject line and address and all.");
        if(emailRequest.getTone()!= null && !emailRequest.getTone().isEmpty())
           prompt.append("The tone should be ").append(emailRequest.getTone());
        else
            prompt.append("The tone should be professional");

        prompt.append("Original Email : \n").append(emailRequest.getEmailContent());

        return prompt.toString();
    }
}
