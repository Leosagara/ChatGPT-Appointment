package fiap.com.app.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fiap.com.app.models.base.BaseEntity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Form extends BaseEntity {

    private String age;
    private String gender;
    private String symptoms;
    private String medical_history;
    private String habits;
    private String others;
    private String prompt;
    private String response;

    public Form(String age, String gender, String symptoms, String medical_history, String habits, String others) {
        this.age = age;
        this.gender = gender;
        this.symptoms = symptoms;
        this.medical_history = medical_history;
        this.habits = habits;
        this.others = others;
    }

    public String generatePrompt(){
        return "Eu tenho "+age+" anos de idade,gênero:"+gender+",meus sintomas são:"+symptoms+",meu histórico de doenças é:"+
               medical_history+",e meu habitos são:"+habits+".Considerando estes fatores quais exames eu deveria fazer e em quanto tempo preciso fazê-los";
    }

    public String generateResponse(Form form) throws IOException, InterruptedException {
        String apiKey = "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";
        String requestBody = """
            {
                "model": "gpt-4",
                "messages": [{"role": "user", "content": "%s"}],
                "temperature": 0.7,
                "max_tokens": 150
            }
            """.formatted(form.getPrompt());
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            String content = rootNode.at("/choices/0/message/content").asText();

        return content;
    }

    public Form(String age, String gender, String symptoms, String medical_history, String habits, String others, String text) throws IOException, InterruptedException {
        this.age = age;
        this.gender = gender;
        this.symptoms = symptoms;
        this.medical_history = medical_history;
        this.habits = habits;
        this.others = others;
    }
}
