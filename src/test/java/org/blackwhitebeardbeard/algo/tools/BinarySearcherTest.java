package org.blackwhitebeardbeard.algo.tools;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BinarySearcherTest {

    @AllArgsConstructor
    @Value
    private static class IsElementPresentInArrayTestInput {

        private final Double[] tArray;

        private final Double t;

        private final Comparator<Double> tComparator;

        private final Optional<Class<? extends Exception>> expectedException;

        private final Optional<Boolean> expectedResult;

    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void test_isElementPresentInArray(final IsElementPresentInArrayTestInput testInput) {
        final Optional<Class<? extends Exception>> expectedException = testInput.getExpectedException();
        final Optional<Boolean> expectedResult = testInput.getExpectedResult();
        if (expectedException.isPresent() && expectedResult.isPresent()) {
            throw new IllegalArgumentException("Cannot have both expectedException and expectedResult present.");
        }

        expectedException
                .ifPresent((e) -> assertThatExceptionOfType(e)
                        .isThrownBy(() -> BinarySearcher
                                .IsElementPresentInArray(
                                        testInput.getTArray(),
                                        testInput.getT(),
                                        testInput.getTComparator())));

        expectedResult
                .ifPresent(result -> assertThat(result)
                        .isEqualTo(BinarySearcher.IsElementPresentInArray(
                                testInput.getTArray(),
                                testInput.getT(),
                                testInput.getTComparator())));
    }

    public static Stream<Arguments> provideArguments() {
        return Stream
                .of(
                        new IsElementPresentInArrayTestInput(new Double[] { 1.0, 31.0, 41.0, 51.0, 61.0, 101.0 }, 31.0, Double::compareTo, Optional.empty(), Optional.of(true)),
                        new IsElementPresentInArrayTestInput(new Double[] { 1.0, 31.0, 41.0, 51.0, 61.0, 101.0 }, 30.0, Double::compareTo, Optional.empty(), Optional.of(false)),
                        new IsElementPresentInArrayTestInput(new Double[] { 1.0 }, 30.0, Double::compareTo, Optional.empty(), Optional.of(false)),
                        new IsElementPresentInArrayTestInput(null, 15.2, Double::compareTo, Optional.of(IllegalArgumentException.class), Optional.empty()),
                        new IsElementPresentInArrayTestInput(new Double[] { 1.0, 31.0, 41.0, 51.0, 61.0, 101.0 }, 30.0, null, Optional.of(IllegalArgumentException.class), Optional.empty()))
                .map(Arguments::of);
    }
}
