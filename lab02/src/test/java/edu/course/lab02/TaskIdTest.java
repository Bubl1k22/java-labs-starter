package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskIdTest {

    @Test
    void equalIdsHaveSameValue() {
        TaskId first = new TaskId("TASK-1");
        TaskId second = new TaskId("TASK-1");

        assertEquals(first, second);
        assertEquals("TASK-1", first.value());
    }

    @Test
    void rejectsBlankValue() {
        assertThrows(IllegalArgumentException.class, () -> new TaskId(null));
        assertThrows(IllegalArgumentException.class, () -> new TaskId(" "));
    }

    @Test
    void projectTaskExposesTaskId() {
        ProjectTask task = new ProjectTask("TASK-9", "Review", TaskStatus.NEW, 1);

        assertEquals(new TaskId("TASK-9"), task.taskId());
    }
}
