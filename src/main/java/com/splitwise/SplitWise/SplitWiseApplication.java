package com.splitwise.SplitWise;

import com.splitwise.SplitWise.commands.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitWiseApplication implements CommandLineRunner {

	private CommandExecutor commandExecutor;
	private Scanner scanner = new Scanner(System.in);

	@Autowired
	public SplitWiseApplication(CommandExecutor commandExecutor){
		this.commandExecutor = commandExecutor;
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitWiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(true){
			String input = scanner.nextLine();
			commandExecutor.execute(input);
		}
	}
}
