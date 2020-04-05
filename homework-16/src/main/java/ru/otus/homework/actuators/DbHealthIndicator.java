package ru.otus.homework.actuators;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
@RequiredArgsConstructor
public class DbHealthIndicator implements HealthIndicator {

    private final DataSource dataSource;

    @Override
    public Health health() {
        try {
            Connection connection =  dataSource.getConnection();
            return Health.up()
                    .status(Status.UP)
                    .withDetail("message","Database is working")
                    .build();
        }
        catch (Exception e) {
            return Health.down(e)
                    .status(Status.DOWN)
                    .withDetail("message", "Database is down")
                    .build();
        }
    }
}
