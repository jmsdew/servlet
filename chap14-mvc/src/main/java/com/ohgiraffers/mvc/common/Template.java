package com.ohgiraffers.mvc.common;

import com.mysql.cj.Session;
import com.ohgiraffers.mvc.employee.dao.EmpMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSession(){

        if(sqlSessionFactory == null) {
            Properties prop = new Properties();
            try {
                prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));        // 기존주소를 넣으면 맞지 않음

                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String pass = prop.getProperty("pass");



                Environment environment = new Environment(
                        "dev",
                        new JdbcTransactionFactory(),
                        new PooledDataSource(driver, url, user, pass)
                );

                Configuration configuration = new Configuration(environment);
                // 매퍼등록
                configuration.addMapper(EmpMapper.class);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return sqlSessionFactory.openSession(false);
    }
}
