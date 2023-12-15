import org.example.Task;
import org.example.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @org.junit.jupiter.api.Test
    void addTask() {
        Task task = new Task("1234567890", "test", "testing");
        TaskService taskService = new TaskService();
        Task oldTask = taskService.addTask(task);
        Assertions.assertTrue(oldTask == null);

        Task fetchedTask = taskService.getTask(task.getTaskId());
        Assertions.assertTrue(fetchedTask.equals(task));
    }

    @org.junit.jupiter.api.Test
    void removeTask() {
        Task task = new Task("1234567890", "test", "testing");
        TaskService taskService = new TaskService();
        Task oldTask = taskService.removeTask(task.getTaskId());
        Assertions.assertTrue(oldTask == null);

        taskService.addTask(task);
        oldTask = taskService.removeTask(task.getTaskId());
        Assertions.assertTrue(oldTask.equals(task));

        task = taskService.getTask(task.getTaskId());
        Assertions.assertTrue(task == null);

    }

    @org.junit.jupiter.api.Test
    void updateTaskName() {
        Task task = new Task("1234567890", "test", "testing");

        TaskService taskService = new TaskService();
        Task oldTask = taskService.updateTaskName(task.getTaskId(), "updatedTest");
        Assertions.assertTrue(oldTask == null);

        oldTask = taskService.addTask(task);
        Assertions.assertTrue(oldTask == null);

        oldTask = taskService.updateTaskName(task.getTaskId(), "updatedTest");
        Assertions.assertTrue(oldTask.equals(task));

        Task fetchedTask = taskService.getTask(task.getTaskId());
        Assertions.assertTrue(fetchedTask.getTaskId() == task.getTaskId());
        Assertions.assertTrue(fetchedTask.getName() == "updatedTest");
        Assertions.assertTrue(fetchedTask.getDescription() == task.getDescription());
    }

    @org.junit.jupiter.api.Test
    void updateTaskDescription() {
        Task task = new Task("1234567890", "test", "testing");
        TaskService taskService = new TaskService();
        Task oldTask = taskService.updateTaskDescription(task.getTaskId(), "updatedDescription");
        Assertions.assertTrue(oldTask == null);

        oldTask = taskService.addTask(task);
        Assertions.assertTrue(oldTask == null);

        oldTask = taskService.updateTaskDescription(task.getTaskId(), "updatedDescription");
        Assertions.assertTrue(oldTask.equals(task));

        Task fetchedTask = taskService.getTask(task.getTaskId());
        Assertions.assertTrue(fetchedTask.getTaskId() == task.getTaskId());
        Assertions.assertTrue(fetchedTask.getName() == task.getName());
        Assertions.assertTrue(fetchedTask.getDescription() == "updatedDescription");
    }


}