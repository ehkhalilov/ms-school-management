package com.example.schoolmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    @Schema(description = "it's unique id",title = "id")
    private Long id;
    @Schema(description = "it's title",title = "title")
    private String title;
}
