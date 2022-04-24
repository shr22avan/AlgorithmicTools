package org.blackwhitebeardbeard.algo.tools;

import org.blackwhitebeardbeard.algo.tools.stack.ArrayBasedStack;
import org.blackwhitebeardbeard.algo.tools.stack.Stack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void test_stack(final Stack<Long> stack) {
        final List<Long> longList = Stream.of(1L, 2L, 3L, 4L, 5L).collect(Collectors.toList());

        assertThat(stack.peek()).isEqualTo(Optional.empty());

        longList
                .forEach(stack::push);

        assertThat(stack.peek())
                .isEqualTo(Optional.of(5L));

        Collections.reverse(longList);

        longList
                .forEach(e -> assertThat(stack.pop())
                        .isEqualTo(e));


    }
    public static Stream<Arguments> provideArguments() {
        return Stream.of(new ArrayBasedStack<Long>(5))
                .map(Arguments::of);
    }
}
