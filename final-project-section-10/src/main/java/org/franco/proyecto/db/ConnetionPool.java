package org.franco.proyecto.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnetionPool {

    private static HikariDataSource dataSource;

    static {
        System.out.println("Bloque static...");
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://ep-old-sea-acwifamo-pooler.sa-east-1.aws.neon.tech/jdbc-curso?sslmode=require&channelBinding=require");
        config.setUsername("neondb_owner");
        config.setPassword("npg_lJrhZKCy5XT3");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        config.setIdleTimeout(30000);
        config.setConnectionTimeout(30000);

        //Detencion de fugas
        config.setLeakDetectionThreshold(1500);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closePool(){
        if(dataSource != null && !dataSource.isClosed()){
            dataSource.close();
            System.out.println("Connection Pool cerrado...");
        }
    }

}
