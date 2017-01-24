package com.jhwan.blog;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.jhwan.blog.mapper", sqlSessionFactoryRef = "sqlSessionFactoryBean")
@PropertySource({ "classpath:config/jdbc.properties" })
public class MyBatisConfig {

    @Value("${db.driver-class-name}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.initial-size:50}")
    private int initialSize; // 최초 실행시 확보하는 초기 커넥션 수
    @Value("${db.max-total:100}")
    private int maxTotal; // 유효한 커넥션을 유지하는 최대 수
    @Value("${db.max-idle:100}")
    private int maxIdle; // Idle 커넥션을 유지하는 최대 수
    @Value("${db.min-idle:50}")
    private int minIdle; // Idle 커넥션을 유지하는 최소 수
    @Value("${db.max-wait-millis:10000}")
    private int maxWaitMillis; // 풀에서 유효한 커넥션을 가져올 때까지 기다리는 밀리초. 이 시간이 지나도 없으면 Exception 발생
    @Value("${db.validation-query:SELECT 1 FROM DUAL}")
    private String validationQuery; // 커넥션을 테스트하는 쿼리
    @Value("${db.validation-query-timeout:5}")
    private int validationQueryTimeout; // 커넥션을 테스트할 때 테스트 쿼리 응답시간이 해당 시간 지나면 유효한 커넥션이 아님을 판단하는 timeout(초).
    @Value("${db.test-on-borrow:true}")
    private boolean testOnBorrow; // 풀에서 커넥션을 가져올때 true이면, 유효성 검사 과정에서 테스트 쿼리를 실행함
    @Value("${db.test-on-return:false}")
    private boolean testOnReturn; // 풀에서 커넥션을 가져올때 true이면, 커넥션 반환 과정에서 테스트 쿼리를 실행함
    @Value("${db.test-while-idle:true}")
    private boolean testWhileIdle; // idle 커넥션을 체크하는지 여부. true이며 테스크 쿼리를 실행해서 유효하지 않는 경우 풀에서 제거됨
    @Value("${db.time-between-eviction-runs-millis:30000}")
    private int timeBetweenEvictionRunsMillis; // idle 커넥션 체크하는 시간 간격(밀리초)
    @Value("${db.min-evictable-idle-time-millis:30000}")
    private int minEvictableIdleTimeMillis; // 커넥션이 idle 상태로 들어갈 것 같은 시간 간격(밀리초).최종 사용한 시간 이후 커넥션 유효성 체크가 이루어진다.
    @Value("${db.remove-abandoned-timeout:60}")
    private int removeAbandonedTimeout; // 유효하지 않는 커넥션을 제거할때 해당 시간(초)이 지나는 후 제거
    @Value("${db.remove-abandoned-on-borrow:true}")
    private boolean removeAbandonedOnBorrow; // 풀에서 커넥션을 가져올때 유효하지 않는 커넥션을 removeAbandonedTimeout(기본:300) 후 제거할 지 여부
    @Value("${db.log-abandoned:true}")
    private boolean logAbandoned; // 제거과정의 로그 트레이스 여부

    @Bean(name = "dataSource")
    public DataSource dataSource() throws PropertyVetoException {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxTotal(maxTotal);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWaitMillis(maxWaitMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setValidationQueryTimeout(validationQueryTimeout);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        dataSource.setRemoveAbandonedOnBorrow(removeAbandonedOnBorrow);
        dataSource.setLogAbandoned(logAbandoned);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setTestWhileIdle(testWhileIdle);

        return dataSource;
    }

    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(ApplicationContext applicationContext, @Qualifier("dataSource") DataSource dataSource, @Value("${db.resource.config:null}") String configResource,
                                                       @Value("${db.resource.mapper:null}") String mapperResource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // factoryBean.setTypeAliasesPackage(packageName);
        factoryBean.setConfigLocation(applicationContext.getResource(configResource));
        factoryBean.setMapperLocations(applicationContext.getResources(mapperResource));
        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource);
    }

}
