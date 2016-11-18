package com.bitwise.manageme.rssson.web.config;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.js.ajax.AjaxUrlBasedViewResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.bitwise.manageme.rssson.util.converters.RoleToUserConverter;
import com.bitwise.manageme.rssson.util.converters.StaffToSubjectConverter;
import com.bitwise.manageme.rssson.util.converters.StudentToSubjectConverter;
import com.bitwise.manageme.rssson.web.security.CredentialValidation;
import com.bitwise.manageme.rssson.web.security.RSSSONAuthenticationProvider;
import com.bitwise.manageme.rssson.web.security.RSSSONUserContext;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.bitwise.manageme.rssson.web"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**/*").addResourceLocations("classpath:/META-INF/web-resources/");
    }

	@Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/index.htm").setViewName("index");
    }
	
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
  
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    	exceptionResolvers.add(simpleMappingExceptionResolver());
    }
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
    
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
    	SimpleMappingExceptionResolver exceptionResolver;
    	exceptionResolver = new SimpleMappingExceptionResolver();
    	Properties mappings = new Properties();
    	mappings.setProperty("DataAccessException", "dataAccessFailure");
    	mappings.setProperty("AccessDeniedException", "accessdenied");
    	mappings.setProperty("NoSuchRequestHandlingException", "resourceNotFound");
    	mappings.setProperty("TypeMismatchException", "resourceNotFound");
    	mappings.setProperty("MissingServletRequestParameterException", "resourceNotFound");
    	Properties statusCodes = new Properties();
    	mappings.setProperty("login", String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
    	exceptionResolver.setDefaultErrorView("defaulterror");
    	exceptionResolver.setExceptionMappings(mappings);
    	exceptionResolver.setStatusCodes(statusCodes);
    	return exceptionResolver;
    }
    
    @Bean
    public ViewResolver tilesViewResolver() {
    	UrlBasedViewResolver urlBasedVR = new AjaxUrlBasedViewResolver();
    	urlBasedVR.setOrder(1);
    	urlBasedVR.setViewClass(TilesView.class);
    	return urlBasedVR;
    }
    
    @Bean
    public ViewResolver viewResolver() {
    	InternalResourceViewResolver internalResourceVR = new InternalResourceViewResolver();
    	internalResourceVR.setOrder(2);
    	internalResourceVR.setPrefix("/WEB-INF/views");
    	internalResourceVR.setSuffix(".htm");
    	internalResourceVR.setViewClass(JstlView.class);
    	return internalResourceVR;
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer() {
    	TilesConfigurer tilesConfigurer = new TilesConfigurer();
    	tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles/tiles-configuration.xml"});
    	return tilesConfigurer;
    }
    
    @Bean
    public RSSSONAuthenticationProvider authenticationProvider() {
    	return new RSSSONAuthenticationProvider();
    }
    
    @Bean
    public CredentialValidation credentialValidation() {
    	return new CredentialValidation();
    }
    
    @Bean
    public RSSSONUserContext userContext() {
    	return new RSSSONUserContext();
    }
    
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
    	return new StandardServletMultipartResolver();
    }
    
    @Bean
    public RoleToUserConverter roleToUserConverter() {
    	return new RoleToUserConverter();
    }
    
    @Bean
    public StudentToSubjectConverter studentToSubjectConverter() {
    	return new StudentToSubjectConverter();
    }
    
    @Bean
    public StaffToSubjectConverter staffToSubjectConverter() {
    	return new StaffToSubjectConverter();
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yy-MM-dd"));
        registry.addConverter(roleToUserConverter());
        registry.addConverter(studentToSubjectConverter());
        registry.addConverter(staffToSubjectConverter());
    }
}
