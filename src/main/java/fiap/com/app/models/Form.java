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

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name="form")
@AttributeOverride(name = "id", column = @Column(name = "form_id"))
public class Form extends BaseEntity {

    private String age;
    private String gender;
    private String symptoms;
    private String medical_history;
    private String habits;
    @Column(length = 1000)
    private String prompt;
    @Column(length = 3000)
    private String response;

    public String generatePrompt(){
        return "Eu tenho "+age+" anos de idade,gênero:"+gender+",meus sintomas são:"+symptoms+",meu histórico de doenças é:"+
               medical_history+",e meu habitos são:"+habits+"." +
                "Considerando estes fatores indique 1 exame para eu fazer e de quanto em quanto tempo devo fazer. Responda com respostas curtas.";
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
        String requestBody2 = """
            {
                "model": "gpt-4",
                "messages": [{"role": "user", "content": "%s"}],
                "temperature": 0.7,
                "max_tokens": 150
            }
            """.formatted("Me responda as proximas perguntas somente com: (Tipo de exame)-(Em quanto tempo preciso fazer o exame), pode ser?");

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody2))
                .build();
        HttpResponse<String> response2 = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = response.body();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        String content = rootNode.at("/choices/0/message/content").asText();
        System.out.println(response2.body());
        return content;


    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
