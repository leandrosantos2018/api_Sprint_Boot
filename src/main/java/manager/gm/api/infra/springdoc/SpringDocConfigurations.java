package manager.gm.api.infra.springdoc;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))).info(new Info()
                        .title("GM Consultoria API")
                        .description("API  Rest de gestão de consultoria , além de agendamento e cancelamento de consultoria")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Squard Backend")
                                .email("backend@nmd.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("www.nmdsolucoesdigitais.com.br")));
    }
}
