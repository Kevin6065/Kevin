package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.model.BenzEngine;
import com.model.Toyota;

@Configuration
public class Carconfig {
	
	@Bean
	public Toyota toyota(){
		return new Toyota(new BenzEngine());//Bean是跟method的名稱走
	}
	


}
