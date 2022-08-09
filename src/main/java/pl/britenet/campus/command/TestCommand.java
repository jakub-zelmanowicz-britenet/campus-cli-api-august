package pl.britenet.campus.command;

import pl.britenet.campus.Constants;

public class TestCommand extends Command {

    public TestCommand() {
        super(Constants.COMMAND_NAME_TEST);
    }

    @Override
    public void execute() {
        System.out.println("Test");
    }
}
