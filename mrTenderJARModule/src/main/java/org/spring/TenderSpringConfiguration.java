package org.spring;

import org.mrTender.users.service.TenderUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TenderSpringConfiguration {
	
	@Bean
	public TenderUserDetailsService tenderUserDetailsService(){
		return new TenderUserDetailsService();
	}

}
