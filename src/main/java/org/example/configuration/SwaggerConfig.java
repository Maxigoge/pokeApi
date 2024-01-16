package org.example.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {
    private static final String API_TITLE = "Pokemon REST API";
    private static final String API_DESCRIPTION =
            "Conjunto de End Points para consultas de Pokemones mediante pokeapi.";

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .servers(listServers())
                .info(apiInfo());
    }

    private List<Server> listServers() {
        ArrayList<Server> listServers = new ArrayList<>();
        Server server = new Server();
        server.setUrl("https://pokemonrestapi.onrender.com/");
        listServers.add(server);
        return listServers;
    }

    private Info apiInfo() {
        return new Info()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version("1.0.0")
                .termsOfService("Terms of service")
                .contact(new Contact()
                        .name("Maximiliano Nahuel Gomez Geneiro")
                        .email("kraizyn@gmail.com")
                        .url("https://pokemonrestapi.onrender.com/"));
    }

}
