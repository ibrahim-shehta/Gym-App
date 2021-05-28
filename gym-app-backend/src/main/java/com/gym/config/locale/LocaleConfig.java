package com.gym.config.locale;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class LocaleConfig {

	
	// when remove this bean "localization work fine may this is default configuration of spring boot"
	@Bean 
	public LocaleResolver localeResolver() {
		/**
		 * AcceptHeaderLocaleResolver get value form accept-language and set it in LocaleContextHolder and get value by LocaleContextHolder.getLocale()
		 * but if you use SessionLocaleResolver you should get value from header by @RequestHeader(name="Accept-Language", required=false) Locale locale
		 */
		AcceptHeaderLocaleResolver  localeResolver = new AcceptHeaderLocaleResolver();
	    localeResolver.setDefaultLocale(Locale.US);
	    return localeResolver;
	}
	
	
	// instead configure bean you can use this property in application .properties --> spring.messages.basename=local/messages
	 
	/*@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
		rs.setBasename("local/messages");
		rs.setDefaultEncoding("UTF-8");
		return rs;
	}*/	
}
