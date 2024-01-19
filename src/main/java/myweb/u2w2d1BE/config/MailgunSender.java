package myweb.u2w2d1BE.config;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import myweb.u2w2d1BE.entities.Author;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailgunSender {
    private String mailgunApiKey;
    private String mailgunDomainname;

    private String email;

    public MailgunSender(@Value("${mailgun.apikey}") String mailgunApiKey,
                         @Value("${mailgun.domainname}") String mailgunDomainName,
                         @Value("${personal.email}") String email) {
        this.mailgunApiKey = mailgunApiKey;
        this.mailgunDomainname = mailgunDomainName;
        this.email = email;
    }

    public void sendRegistrationEmail(Author recipient) {
        // codice che invia l'email
        // Per inviare un'email devo mandare una richiesta http di tipo POST ai server mailgun
        // Per farlo uso la libreria unirest-java

        HttpResponse<JsonNode> response = Unirest.post("https://api.mailgun.net/v3/" + this.mailgunDomainname + "/messages")
                .basicAuth("api", this.mailgunApiKey)
//                .queryString("from", "Isuru Ferna <" + this.email + ">")
                .queryString("from", "Isuru Fernando <isurufernando08@gmail.com>")
                .queryString("to", recipient.getEmail())
                .queryString("subject", "Registrazione avvenuta con successo!")
                .queryString("text", "Complimenti " + recipient.getFirstName() + " " + recipient.getLastName() + "  per esserti registrato!")
                .asJson();

        System.out.println("this is reponse: " + response.getBody());
    }
}
