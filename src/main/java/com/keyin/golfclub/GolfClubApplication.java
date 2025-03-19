package com.keyin.golfclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class GolfClubApplication {
    public static void main(String[] args) {
        SpringApplication.run(GolfClubApplication.class, args);
    }

    // 🔥 Force Spring to recognize the driver
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/golf_club_db");
        dataSource.setUsername("root");
        dataSource.setPassword("angel1305");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }
}
