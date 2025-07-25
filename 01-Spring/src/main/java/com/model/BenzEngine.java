package com.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BenzEngine implements Engine {

	@Override
	public void start() {
		System.out.println("BenzEngine 啟動");
	}

}
