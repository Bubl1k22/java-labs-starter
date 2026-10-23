package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectTaskTest {

    @Test
    void createsValidTask() {
        ProjectTask task = new ProjectTask("TASK-1", "Write tests", TaskStatus.NEW, 4);

        assertEquals("TASK-1", task.getId());
        assertEquals("Write tests", task.getTitle());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertEquals(4, task.getEstimatedHours());
        assertFalse(task.isCompleted());
    }

    @Test
    void changeStatusUpdatesTask() {
        ProjectTask task = sampleTask();

        task.changeStatus(TaskStatus.DONE);

        assertEquals(TaskStatus.DONE, task.getStatus());
        assertTrue(task.isCompleted());
    }

    @Test
    void increaseEstimateAddsPositiveHours() {
        ProjectTask task = sampleTask();

        task.increaseEstimate(3);

        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void constructorRejectsBlankId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(null, "Title", TaskStatus.NEW, 2));
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("  ", "Title", TaskStatus.NEW, 2));
    }

    @Test
    void constructorRejectsBlankTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", null, TaskStatus.NEW, 2));
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "", TaskStatus.NEW, 2));
    }

    @Test
    void constructorRejectsNullStatus() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "Title", null, 2));
    }

    @Test
    void constructorRejectsNonPositiveHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "Title", TaskStatus.NEW, 0));
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "Title", TaskStatus.NEW, -3));
    }

    @Test
    void changeStatusRejectsNull() {
        ProjectTask task = sampleTask();

        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
        assertEquals(TaskStatus.NEW, task.getStatus());
    }

    @Test
    void increaseEstimateRejectsNonPositiveHours() {
        ProjectTask task = sampleTask();

        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(0));
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(-2));
        assertEquals(5, task.getEstimatedHours());
    }

    @Test
    void idAndTitleCannotBeReassigned() {
        ProjectTask task = sampleTask();
        String originalId = task.getId();
        String originalTitle = task.getTitle();

        task.changeStatus(TaskStatus.IN_PROGRESS);
        task.increaseEstimate(1);

        assertEquals(originalId, task.getId());
        assertEquals(originalTitle, task.getTitle());
    }

    private static ProjectTask sampleTask() {
        return new ProjectTask("TASK-1", "Write tests", TaskStatus.NEW, 5);
    }
}
