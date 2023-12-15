package org.example;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> taskMap;

    public TaskService() {
        taskMap = new HashMap<>();
    }

    public Task addTask(Task task) {
        return taskMap.put(task.getTaskId(), task);
    }

    public Task updateTaskName(String taskId, String name) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            return null;
        }

        task.setName(name);
        return addTask(task);
    }

    public Task updateTaskDescription(String taskId, String description) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            return null;
        }

        task.setDescription(description);
        return addTask(task);
    }

    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }

    public Task removeTask(String taskId) {
        return taskMap.remove(taskId);
    }
}
