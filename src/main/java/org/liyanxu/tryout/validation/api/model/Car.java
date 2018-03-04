package org.liyanxu.tryout.validation.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Min(value = 1800, message = "Min year is 1800")
    @Max(value = 2100, message = "Max year is 2100")
    private int year;

    @NotNull(message = "Make cannot be null")
    private String make;

    @NotNull(message = "Model cannot be null")
    private String model;

    private String color;

}
