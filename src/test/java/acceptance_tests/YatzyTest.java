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
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        }});

        yatzy.play();

        context.assertIsSatisfied();
    }
}
