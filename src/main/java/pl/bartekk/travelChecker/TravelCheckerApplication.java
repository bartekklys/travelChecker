package pl.bartekk.travelChecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RestController
@SpringBootApplication
public class TravelCheckerApplication {

	private final WebClient webClient;

	@Autowired
	public TravelCheckerApplication(WebClient webClient) {
		this.webClient = webClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(TravelCheckerApplication.class, args);
	}

	@GetMapping("/test")
	public String getHtmlContent() {
		System.out.println("Test ok !!! :)");

		String htmlContent = webClient.get().retrieve().bodyToMono(String.class).block();
		int index1 = htmlContent.lastIndexOf("<b class=\"strikeT\" data-discountpercent");



		return  webClient.get().retrieve().bodyToMono(String.class).block();
	}

	//<b class="strikeT" data-discountpercent="54">4&nbsp;049 zł</b>
	//<span class="specialPrice"><span>-54%</span></span>
	//<b class="price" id="descShortPrice">1&nbsp;879 zł</b>

	@Scheduled(cron = "${collect.data.task.cron}")
	public void doNothing() {
		System.out.println("@Scheduled Test ok !! :)");
	}

}
