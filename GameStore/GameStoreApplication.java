package com.example.GameStore;

import com.example.GameStore.model.Developer;
import com.example.GameStore.model.Order;
import com.example.GameStore.model.User;
import com.example.GameStore.model.Game;
import com.example.GameStore.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GameStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(GameService gameService, DeveloperService developerService, UserService userService, OrderService orderService){
		return args -> {

			Developer developer = developerService.saveDeveloper(new Developer("Red Barrels","USA","us"));
			Developer developer1 = developerService.saveDeveloper(new Developer("Activision","Britain","uk"));
			Developer developer2 = developerService.saveDeveloper(new Developer("Ubisoft","Bulgaria","bg"));
			Developer developer3 = developerService.saveDeveloper(new Developer("Arika","Japan","jp"));
			Developer developer4 = developerService.saveDeveloper(new Developer("Krafton","Finland","fn"));
			Developer developer5 = developerService.saveDeveloper(new Developer("Epic Games","Paris","ps"));

			Game game =
					gameService.saveGame(new Game("Outlast","123",100,20.0,"Horror", 2012,developer));
			Game game1 =
					gameService.saveGame(new Game("Prototype","1234",220,30.0,"Action", 2018,developer));
			Game game2 =
					gameService.saveGame(new Game("Fortnite","12345",200,120.0,"Shooter", 2015,developer5));
			Game game3 =
					gameService.saveGame(new Game("Tetris99","123456",300,50.0,"Puzzle", 2020,developer3));
			Game game4 =
					gameService.saveGame(new Game("PUBG","1234567",400,60.0,"Battle royale", 2016,developer4));
			Game game5 =
					gameService.saveGame(new Game("Assassins Creed II","123",990,5.6,"Action-Adventure", 2010,developer2));
			Game game6 =
					gameService.saveGame(new Game("Serious Sam II","123",990,5.6,"Action-Adventure", 2007,developer4));
			Game game7 =
					gameService.saveGame(new Game("Watch Dogs","123",990,5.6,"Action-Adventure", 2013,developer3));
			Game game8 =
					gameService.saveGame(new Game("CoD","123",990,5.6,"Shooter", 2011,developer1));


			User user = userService.saveUser(new User("Vasko", "A1B2C3D4", "vasko@gmail.com", "user"));
			User user1 = userService.saveUser(new User("Yavor", "1234", "yavor@gmail.com", "user"));
			User user2 = userService.saveUser(new User("Ivan", "D1C2B3A4", "ivan@abv.bg", "user"));
			User user3 = userService.saveUser(new User("Elena", "4321", "elena@yahoo.com", "user"));
			User user4 = userService.saveUser(new User("Dimitar", "5678", "dimitar@email.bg", "user"));
			User user5 = userService.saveUser(new User("Georgi", "9087", "georgi@mail.com", "user"));


			Order order = orderService.placeOrder(user.getUsername(), game3.getName(),3);
			Order order1 = orderService.placeOrder(user3.getUsername(), game1.getName(),10);
			Order order2 = orderService.placeOrder(user2.getUsername(), game2.getName(),20);
			Order order3 = orderService.placeOrder(user1.getUsername(), game3.getName(),15);
			Order order4 = orderService.placeOrder(user4.getUsername(), game4.getName(),9);
			Order order5 = orderService.placeOrder(user3.getUsername(), game5.getName(),8);
			Order order6 = orderService.placeOrder(user5.getUsername(), game6.getName(),11);
			Order order7 = orderService.placeOrder(user1.getUsername(), game7.getName(),12);
			Order order8 = orderService.placeOrder(user.getUsername(), game8.getName(),14);

		};
	}
}
