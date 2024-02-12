package com.example.RestApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Task {
    @Id
    private String taskId;
    private String taskDescription;
    private String taskName;
    private int severity;
    private String assignee;
    private String storyPoint;

}
