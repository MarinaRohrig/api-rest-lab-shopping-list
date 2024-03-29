package br.com.futurodev.shoppinglist.springfox;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(metaData())
                .tags(new Tag("Product", "Gerencia produtos"),
                        new Tag("Category", "Gerencia categorias"));

    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Lab Shopping List REST API")
                .description("Lab Shopping List Spring Boot REST API ")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html") // informamos o arquivo a ser renderizado no navegador
                .addResourceLocations("classpath:/META-INF/resources/"); // informamos o caminho do arquivo

        registry.addResourceHandler("/webjars/**") // informa outros arquivos de css, js, png dentre outros
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
