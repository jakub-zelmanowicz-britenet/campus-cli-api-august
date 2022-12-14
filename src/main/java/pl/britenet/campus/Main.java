package pl.britenet.campus;

import pl.britenet.campus.command.Command;
import pl.britenet.campus.command.CommandService;
import pl.britenet.campus.command.TestCommand;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;

        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);

        CommandService commandService = new CommandService();
        commandService.registerCommand(new TestCommand());

        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            String commandName = scanner.nextLine();
            Optional<Command> command = commandService.getCommand(commandName);

            if (command.isPresent()) {
                command.get().execute();
            }
            else {
                System.out.println("Unknown Command.");
            }
        }
    }

}
