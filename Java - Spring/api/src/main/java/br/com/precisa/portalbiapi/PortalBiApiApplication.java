package br.com.precisa.portalbiapi;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@RestController
@SpringBootApplication
public class PortalBiApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        // Toda vez que o projeto for inicializado faz um log com a data/hora do evento
        // e a versão atual do projeto (JAR)
        try {
            BufferedWriter write;
            LocalDateTime data = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                    .withLocale(new Locale("pt", "br"));

            String dataInicializado = data.format(formatador);
            String versaoInicializado = PortalBiApiApplication.class.getPackage().getImplementationVersion();

            write = new BufferedWriter(new FileWriter("portal-bi-api-info.txt", true));
            write.write("INICIADO: " + dataInicializado + " VERSÃO: " + versaoInicializado);
            write.newLine();
            write.close();

        } catch (Exception e) {
        }

        SpringApplication.run(PortalBiApiApplication.class, args);
    }
}
