package javaprogramming.commonmistakes.java8;

import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.Assert.*;

public class CoolOptionalTest {

    @Test(expected = IllegalArgumentException.class)
    public void optional() {
        assertSame(Optional.of(1).get(), 1);
        assertSame(Optional.empty().orElse("A"), "A");
        assertFalse(OptionalDouble.empty().isPresent());
        assertSame(Optional.of(1).map(Math::incrementExact).get(), 2);
        assertNull(Optional.of(1).filter(integer -> integer % 2 == 0).orElse(null));
        Optional.empty().orElseThrow(IllegalArgumentException::new);
    }
}
