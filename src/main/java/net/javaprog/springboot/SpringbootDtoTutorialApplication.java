package net.javaprog.springboot;

import net.javaprog.springboot.model.Location;
import net.javaprog.springboot.model.User;
import net.javaprog.springboot.repository.LocationRepository;
import net.javaprog.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class SpringbootDtoTutorialApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoTutorialApplication.class, args);
	}

	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("Kolhapur");
		location.setDescription("Kolhapur is awesome to live, enjoy!");
		location.setLongitude(32.5);
		location.setLatitude(41.7);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstName("Harsh");
		user1.setLastName("Chougule");
		user1.setEmail("harsh@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("Gopal");
		user2.setLastName("Das");
		user2.setEmail("gopal@gmail.com");
		user2.setPassword("secrete");
		user2.setLocation(location);
		userRepository.save(user2);
	}

}