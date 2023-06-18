package com.lolo.address;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class AddressRouter {

    @Bean
    RouterFunction<ServerResponse> route(AddressHandler addressHandler) {

		return RouterFunctions
				.route(GET("/countries")
						.and(accept(MediaType.APPLICATION_JSON)), addressHandler::findCountries)
				.andRoute(GET("/regions")
						.and(accept(MediaType.APPLICATION_JSON)), addressHandler::findRegions);

    }

}
