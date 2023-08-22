package ru.hogwarts.school.services.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.services.OtherService;

import java.util.stream.Stream;

@Service
public class OtherServiceImpl implements OtherService {
    @Override
    public Integer getInteger () {
        int sum = Stream.iterate(1, a -> a + 1)
//                .parallel()
                .peek(it -> System.out.printf("Thread [%s] peek: %d\n",
                        Thread.currentThread().getName(), it))
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
        return sum;
    }
}
