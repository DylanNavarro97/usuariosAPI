package com.usuarios.security.config;

//@Configuration
//@EnableSwagger2
//@EnableWebMvc
//@ComponentScan("com.usuarios.security.usuarios.security.controllers.*")
public class SwaggerConfig  {

/*
    @Value("${app.version")
    String version;

    @Bean
    public Docket api() {
        //docket.securitySchemes(Collections.singletonList(apiKey()))
        //      .securityContexts(Collections.singletonList(securityContext()));
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.usuarios.security.usuarios.security"))
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Usuarios APi")
                .description("Descripcion de mi api")
                .version(version)
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
    } */
}
