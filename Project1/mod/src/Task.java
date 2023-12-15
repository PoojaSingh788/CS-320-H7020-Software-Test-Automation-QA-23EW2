package org.example;

import java.util.Objects;

public class Task {
    private String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if ("".equals(taskId) || taskId.length() > 10
                || "".equals(name) || name.length() > 20
                || "".equals(description) || description.length() > 50) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getTaskId().equals(task.getTaskId()) && getName().equals(task.getName()) && getDescription().equals(task.getDescription());
    }
}
