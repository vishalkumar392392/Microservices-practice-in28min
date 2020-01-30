package com.restApi.course.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getPersonv1() {

		PersonV1 person = new PersonV1("vishal palla");

		return person;
	}
	@GetMapping("/v2/person")
	public PersonV2 getPersonv2() {

		PersonV2 person = new PersonV2(new Name("Bhargavi", "good Girl"));

		return person;
	}
	@GetMapping(value="/person/param",params = "version=1")
	public PersonV1 getPersonParamV1() {

		PersonV1 person = new PersonV1("vishal palla");

		return person;
	}
	@GetMapping(value="/person/param",params = "version=2")
	public PersonV2 getPersonParamV2() {

		PersonV2 person = new PersonV2(new Name("Bhargavi", "good Girl"));

		return person;
	}
	
	@GetMapping(value="/person/header",headers ="X-API-VERSION=1")
	public PersonV1 headerV1() {

		PersonV1 person = new PersonV1("vishal palla");

		return person;
	}
	@GetMapping(value="/person/header",headers ="X-API-VERSION=2")
	public PersonV2 headerV2() {

		PersonV2 person = new PersonV2(new Name("Bhargavi", "good Girl"));

		return person;
	}
	
	@GetMapping(value="/person/produces",produces ="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {

		PersonV1 person = new PersonV1("vishal palla");

		return person;
	}
	@GetMapping(value="/person/produces",produces ="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {

		PersonV2 person = new PersonV2(new Name("Bhargavi", "good Girl"));

		return person;
	}
	
}
