package com.rocketseat.rs_java_certification.seed;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseSeeding {

    private final JdbcTemplate jdbcTemplate;

    private DatabaseSeeding(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/rsjavacertification");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234567");

        DatabaseSeeding databaseSeedding = new DatabaseSeeding(dataSource);
        databaseSeedding.run(args);
    }

    public void run(String... args) {
        executeSqlFile("src/main/resources/create.sql");
    }

    private void executeSqlFile(String filePath) {
        try {
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
            jdbcTemplate.execute(sqlScript);
            System.out.println("Seeding realizado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao executar o arquivo " + e.getMessage());
        }
    }
}
