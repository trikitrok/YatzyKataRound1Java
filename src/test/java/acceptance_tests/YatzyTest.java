package acceptance_tests;

import com.dodevjutsu.kata.yatzy.Console;
import com.dodevjutsu.kata.yatzy.Yatzy;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class YatzyTest {

    Mockery context = new Mockery();

    @Test
    public void game_console_output() {
        Console console = context.mock(Console.class);

        Yatzy yatzy = new Yatzy(console);

        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");
        }});

        yatzy.play();

        context.assertIsSatisfied();
    }
}
