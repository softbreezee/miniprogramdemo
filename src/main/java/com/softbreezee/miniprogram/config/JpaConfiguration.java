package com.softbreezee.miniprogram.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.*;


@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)//启用JPA的事务管理
@EnableJpaRepositories(basePackages = "com.**.dao")//启用了jpa资源库并指定了上面定义的接口资源库的位置
@EntityScan(basePackages = "com.**.entity")//指定定义实体的位置
public class JpaConfiguration {

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){

        return new PersistenceExceptionTranslationPostProcessor();
    }

}
