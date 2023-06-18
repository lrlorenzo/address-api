package com.lolo.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AddressHandler {
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private RegionRepository regionRepository;

	public Mono<ServerResponse> findCountries(ServerRequest request) {
		Flux<Country> countries = countryRepository.findAll();
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(countries, Country.class);
	}
	
	public Mono<ServerResponse> findRegions(ServerRequest request) {
		String countryCode = "%" + request.queryParam("country_code").get() + "%";
		Flux<Region> regions = regionRepository.findByCountryCodeLike(countryCode);
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(regions, Region.class);
	}

}
