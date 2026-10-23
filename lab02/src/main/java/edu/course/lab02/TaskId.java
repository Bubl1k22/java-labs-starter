package edu.course.lab02;

/**
 * Неизменяемый идентификатор задачи. Это значение (value object): два идентификатора
 * с одной и той же строкой равны, а само значение нельзя изменить после создания.
 */
public record TaskId(String value) {

    public TaskId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Id cannot be null or blank");
        }
    }
}
