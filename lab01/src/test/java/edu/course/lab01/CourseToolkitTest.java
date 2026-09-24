package edu.course.lab01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    // Базовые тесты из шаблона

    @Test
    @DisplayName("isEven: возвращает true для четного числа 4")
    void returnsTrueForPositiveEvenNumber() {
        assertTrue(CourseToolkit.isEven(4));
    }

    @Test
    @DisplayName("isEven: возвращает false для нечетного числа 5")
    void returnsFalseForPositiveOddNumber() {
        assertFalse(CourseToolkit.isEven(5));
    }

    // Подготовительная часть

    @Test
    @DisplayName("isEven: возвращает true для отрицательного четного числа -8")
    void returnsTrueForNegativeEvenNumber() {
        assertTrue(CourseToolkit.isEven(-8));
    }

    // isPrime

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 1})
    @DisplayName("isPrime: возвращает false для чисел меньше 2")
    void isPrime_returnsFalseForNumbersLessThanTwo(int number) {
        assertFalse(CourseToolkit.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 17, 31})
    @DisplayName("isPrime: возвращает true для простых чисел")
    void isPrime_returnsTrueForPrimes(int number) {
        assertTrue(CourseToolkit.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 49, 100})
    @DisplayName("isPrime: возвращает false для составных чисел и квадратов простых")
    void isPrime_returnsFalseForCompositesAndSquares(int number) {
        assertFalse(CourseToolkit.isPrime(number));
    }

    // isPalindrome

    @Test
    @DisplayName("isPalindrome: возвращает true для палиндромов")
    void isPalindrome_returnsTrueForValidPalindromes() {
        assertTrue(CourseToolkit.isPalindrome(""));
        assertTrue(CourseToolkit.isPalindrome("a"));
        assertTrue(CourseToolkit.isPalindrome("radar"));
        assertTrue(CourseToolkit.isPalindrome("шалаш"));
    }

    @Test
    @DisplayName("isPalindrome: учитывает регистр и пробелы")
    void isPalindrome_caseAndWhitespaceSensitive() {
        assertFalse(CourseToolkit.isPalindrome("Radar"));
        assertFalse(CourseToolkit.isPalindrome("a ba"));
    }

    @Test
    @DisplayName("isPalindrome: выбрасывает IllegalArgumentException для null")
    void isPalindrome_throwsExceptionForNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    // average

    @Test
    @DisplayName("average: корректно вычисляет среднее для обычного массива")
    void average_calculatesCorrectlyForPositiveNumbers() {
        int[] input = {1, 2, 3, 4};
        assertEquals(2.5, CourseToolkit.average(input), 1e-9);
        // Проверка отсутствия мутации входного массива
        assertArrayEquals(new int[]{1, 2, 3, 4}, input);
    }

    @Test
    @DisplayName("average: корректно вычисляет среднее для отрицательных чисел")
    void average_calculatesCorrectlyWithNegatives() {
        int[] input = {-10, -20, -30};
        assertEquals(-20.0, CourseToolkit.average(input), 1e-9);
    }

    @Test
    @DisplayName("average: выбрасывает исключение для null и пустого массива")
    void average_throwsExceptionOnEmptyOrNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[]{}));
    }
}