package com.lolo.address;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface RegionRepository extends ReactiveCrudRepository<Region, String> {
	Flux<Region> findByCountryCodeLike(String countryCode);
	
}
