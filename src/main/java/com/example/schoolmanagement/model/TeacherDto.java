package com.example.schoolmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDto {
    @Null(groups = CreateModel.class)
    private Long id;
    @Schema(description = "This is name of teacher", required = true, defaultValue = "Elnur", title = "test")
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;
    @Min(18)
    @Max(65)
    private Integer age;
    @NotEmpty
    private String surname;
    @PastOrPresent
    private LocalDate birthDate;
    @NotNull(groups = UpdateModel.class)
    private Subject subject;
    @Email
    private String email;
    @Digits(integer = 6, fraction = 2, message = "Salary must be a numeric value with up to 6 integer digits and 2 fractional digits")
    private BigDecimal salary;
    @Pattern(regexp = "^\\+994\\d{9}$", message = "Phone number must start with +994 followed by 9 digits")
    private String phone;

}
