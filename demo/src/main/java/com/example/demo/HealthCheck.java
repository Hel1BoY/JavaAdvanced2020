package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Controller;

@Controller
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder(Status.OUT_OF_SERVICE);
        return builder.build();
    }

}
