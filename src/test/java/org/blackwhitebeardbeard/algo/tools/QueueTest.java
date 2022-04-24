package org.blackwhitebeardbeard.algo.tools;

import org.blackwhitebeardbeard.algo.tools.queue.ArrayBasedQueue;
import org.blackwhitebeardbeard.algo.tools.queue.Queue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void test_stack(final Queue<Long> queue) {
        final List<Long> longList = Stream.of(1L, 2L, 3L, 4L, 5L).collect(Collectors.toList());

        longList
                .forEach(queue::enqueue);

        longList
                .forEach(e -> assertThat(queue.dequeue())
                        .isEqualTo(e));
    }
    public static Stream<Arguments> provideArguments() {
        return Stream.of(new ArrayBasedQueue<Long>(5))
                .map(Arguments::of);
    }
}
