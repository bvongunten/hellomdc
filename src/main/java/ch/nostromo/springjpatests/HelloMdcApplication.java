package ch.nostromo.springjpatests;

import ch.nostromo.springjpatests.mdc.MdcTaskDecorator;
import ch.nostromo.springjpatests.services.AsynchronousService;
import ch.nostromo.springjpatests.services.SynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class HelloMdcApplication implements CommandLineRunner {

	@Autowired
	SynchronousService synchronousService;

	@Autowired
	AsynchronousService asynchronousService;


	@Override
	public void run(String... args) throws Exception {

		// Set ctx
		MDC.put("userId", "3b");

		synchronousService.synchronousMethod();

		asynchronousService.asynchronousMethod();

	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

		executor.setTaskDecorator(new MdcTaskDecorator());
		executor.setThreadNamePrefix("Thread-");

		executor.initialize();
		return executor;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloMdcApplication.class, args);
	}

}
