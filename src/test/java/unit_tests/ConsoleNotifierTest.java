package unit_tests;

import com.dodevjutsu.kata.yatzy.Category;
import com.dodevjutsu.kata.yatzy.Console;
import com.dodevjutsu.kata.yatzy.ConsoleNotifier;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class ConsoleNotifierTest {

    Mockery context = new Mockery();

    @Test
    public void notifies_current_category() {
        Console console = context.mock(Console.class);
        ConsoleNotifier consoleNotifier = new ConsoleNotifier(console);
        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");
        }});

        consoleNotifier.notifyCategory(Category.Ones);

        context.assertIsSatisfied();
    }
}
