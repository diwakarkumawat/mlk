package com.mlk.fun.config;

import com.mlk.fun.domain.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.mlk.fun")
@ComponentScan({"com.mlk.fun"})
@EntityScan(basePackageClasses = User.class)
public class DatabaseConfig {

}

