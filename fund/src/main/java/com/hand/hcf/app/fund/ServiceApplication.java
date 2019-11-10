package com.hand.hcf.app.fund;

import com.baomidou.mybatisplus.spring.MybatisMapperRefresh;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.hand.hcf.app.fund.config.Constants;
import com.hand.hcf.core.annotation.EnableHcfWeb;
import com.hand.hcf.core.annotation.EnableSwagger2Doc;
import com.hand.hcf.core.annotation.I18nDomainScan;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
@EnableHcfWeb
@MapperScan("com.hand.hcf.app.fund.**.persistence")
@ComponentScan(value = "com.hand.hcf")
@EnableFeignClients({"com.hand.hcf.app"})
@I18nDomainScan(basePackages = {"com.hand.hcf.app.fund.**.domain"})
@EnableConfigurationProperties(MybatisProperties.class)
//@EnableDistributedTransaction
@RemoteApplicationEventScan(basePackages = "com.hand.hcf.app.mdata.client.workflow.event")
@EnableSwagger2Doc
@Slf4j
public class ServiceApplication {
    @Autowired
    private MybatisProperties properties;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ServiceApplication.class);
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        System.getProperties().setProperty("oracle.jdbc.J2EE13Compliant", "true");
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        Environment env = app.run(args).getEnvironment();
        log.info("Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n" +
                        "----------------------------------------------------------",
                env.getProperty("server.port"));
        log.info("OK");
    }

    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active") &&
                !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
        }
    }

    @Bean
    @Profile("local")
    public MybatisMapperRefresh mybatisMapperRefresh(SqlSessionFactory sqlSessionFactory) {
        //项目启动延迟加载时间  单位：秒
        int delaySeconds = 5;
        //刷新时间间隔  单位：秒
        int sleepSeconds = 10;
        MybatisMapperRefresh mybatisMapperRefresh = null;
        log.info("开启mybatis plus mapper.xml 热加载");
        try {
            mybatisMapperRefresh = new MybatisMapperRefresh(this.properties.resolveMapperLocations(), sqlSessionFactory,
                    delaySeconds, sleepSeconds, true);
        } catch (Exception e) {
            log.error("开启mybatis plus mapper.xml 热加载异常");
        }
        return mybatisMapperRefresh;
    }
}