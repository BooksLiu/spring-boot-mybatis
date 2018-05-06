package com.liutong.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(annotationClass = Mapper.class, basePackages = "com.tonghui.dao", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    @Value("${mysql.host}")
    private String host;
    @Value("${mysql.port}")
    private int port;
    @Value("${mysql.database}")
    private String database;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;

    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(30);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(600);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(false);
        dataSource.setValidationQuery("SELECT 'x'");
        return dataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactory factory = createFactory();
        return registryHandler(factory);
    }

    // 创建sqlSessionFactory
    private SqlSessionFactory createFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(this.dataSource());
        factory.setVfs(SpringBootVFS.class);
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        factory.setConfiguration(config);
        return factory.getObject();
    }

    // 注册type handler 暂未使用
    private SqlSessionFactory registryHandler(SqlSessionFactory sqlSessionFactory) {
        // 注册枚举自动转换类使用
        TypeHandlerRegistry typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
        // typeHandlerRegistry.register(class,jdbcType,handler);
        return sqlSessionFactory;

    }

}
