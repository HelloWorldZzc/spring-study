package com.study.configpro.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@Data
@ConfigurationProperties(prefix = "s-config")
@Validated
public class Sconfig {
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration time;
    @Max(value = 100,message = "最大数量不能超过100")
    private int maxCount;
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize maxSize;
}
