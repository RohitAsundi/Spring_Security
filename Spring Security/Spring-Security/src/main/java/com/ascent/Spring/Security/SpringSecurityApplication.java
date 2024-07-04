package com.ascent.Spring.Security;

import com.ascent.Spring.Security.Models.User;
import com.ascent.Spring.Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private  BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
				User user = new User();
				user.setUsername("Rohit");
				user.setPassword(this.bCryptPasswordEncoder.encode("rohit"));
				user.setEmail("rohit@gmail.com");
				user.setRole("ROLE_NORMAL");

				userRepository.save(user);

		User user1 = new User();
		user1.setUsername("Rohan");
		user1.setPassword(this.bCryptPasswordEncoder.encode("rohan"));
		user1.setEmail("rohan@gmail.com");
		user1.setRole("ROLE_ADMIN");

		userRepository.save(user1);
	}
}
