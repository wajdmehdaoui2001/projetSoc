package com.sport.backend.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Bean(name = "customMessageDispatcherServlet")
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public XsdSchema footballSchema() {
        return new SimpleXsdSchema(new ClassPathResource("football-service.wsdl"));
    }

    @Bean(name = "footballService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema footballSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("FootballPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://example.com/football");
        definition.setSchema(footballSchema);
        return definition;
    }
}
