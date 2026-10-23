package edu.course.lab02;

public final class ProjectTask {

    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours) {
        this.id = requireText(id, "id");
        this.title = requireText(title, "title");
        if (status == null) {
            throw new IllegalArgumentException("status cannot be null");
        }
        if (estimatedHours <= 0) {
            throw new IllegalArgumentException("estimatedHours must be positive");
        }
        this.status = status;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("status cannot be null");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }

    public void increaseEstimate(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("hours must be positive");
        }
        this.estimatedHours += hours;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public int getEstimatedHours() {
        return this.estimatedHours;
    }

    public TaskId taskId() {
        return new TaskId(this.id);
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or blank");
        }
        return value;
    }
}
