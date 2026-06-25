package org.example.swaggerexam.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "멋사 swagger 연습용 API",
        version = "1.0",
        description = "멋사 swagger 연습용 API입니다."
        )
)
public class SwaggerConfig {
}
