package org.liyanxu.tryout.validation.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Min(value = 0, message = "Min age is 0")
    @Max(value = 200, message = "Max age is 200")
    private int age;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "FirstCar cannot be null")
    @Valid
    private Car firstCar;   // A person must have a valid first car

    @Valid
    private Car secondCar;  // A person can have a valid second car

}
