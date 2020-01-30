package com.restApi.course.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	//@RequestMapping(method=RequestMethod.GET, path="/helloworld")
	@GetMapping(path="/helloworld")
	public String getString() {
		
		return "Hello world Rest end point is activated";
	}
	
	
	
	@GetMapping(path="/helloworldbean")
	public HelloWorld getBean() {
		
		return new HelloWorld("vishal",8143);
	}
	
	@GetMapping(path="/helloworldbean/{name}")
	public HelloWorld getBeanPathParameter(@PathVariable String name) {
		
		return new HelloWorld(name,9247);
	}
	
	@GetMapping(path="/helloworld/international")
	public String internationalization() {
		
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}

}
