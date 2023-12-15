import org.example.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void taskIdTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("", "test", "testing");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("12345678901", "test", "testing");
        });

        Task task = new Task("1234567890", "test", "testing");

        Assertions.assertTrue(task.getTaskId() == "1234567890");
        Assertions.assertTrue(task.getName() == "test");
        Assertions.assertTrue(task.getDescription() == "testing");
    }

    @Test
    void taskNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("1234567890", "", "testing");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("1234567890", "testabcdefghijklmnouuu", "testing");
        });

        Task task = new Task("1234567890", "test", "testing");

        Assertions.assertTrue(task.getTaskId() == "1234567890");
        Assertions.assertTrue(task.getName() == "test");
        Assertions.assertTrue(task.getDescription() == "testing");

        task.setName("newTest");
        Assertions.assertTrue(task.getName() == "newTest");

    }

    @Test
    void taskDescriptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("1234567890", "test", "");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("1234567890", "test", "testingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtesting");
        });

        Task task = new Task("1234567890", "test", "testing");

        Assertions.assertTrue(task.getTaskId() == "1234567890");
        Assertions.assertTrue(task.getName() == "test");
        Assertions.assertTrue(task.getDescription() == "testing");

        task.setDescription("newDescription");
        Assertions.assertTrue(task.getDescription() == "newDescription");
    }

    @Test
    void equalsTest() {
        Task task1 = new Task("1234567890", "test", "desc");
        Task task2 = new Task("1234567890", "test1", "desc");
        Assertions.assertFalse(task1.equals(task2));

        task2.setName("test");
        Assertions.assertTrue(task1.equals(task2));

    }
}