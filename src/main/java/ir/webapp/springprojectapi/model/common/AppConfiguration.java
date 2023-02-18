package ir.webapp.springprojectapi.model.common;

import ir.webapp.springprojectapi.model.repository.UserDA;
import ir.webapp.springprojectapi.model.service.UserAccessService;
import org.apache.catalina.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

//    @Bean
//    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public UserAccessService userAccessService(){
//        return new UserAccessService();
//    }
}
