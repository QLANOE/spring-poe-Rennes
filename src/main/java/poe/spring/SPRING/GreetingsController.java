package poe.spring.SPRING;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/hi/name/{name}/lastname/{lastname}")
	public Greeting greeting(@PathVariable(value = "name") String name,
			@PathVariable(value = "lastname") String lastname) {
		return new Greeting(counter.incrementAndGet(), "hi " + name + " " + lastname);
	}
}
