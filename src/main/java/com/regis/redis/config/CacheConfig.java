package com.regis.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class CacheConfig {

	@Autowired
	CacheManager cacheManager;
	
	@Scheduled(cron = "0 */2 * * * *")
	public void limpezaCacheCliente() {
		System.out.println("Limpando cache de cliente");
		cacheManager.getCache("cliente").clear();
	}
	
	@Scheduled(cron = "*/30 * * * * *")
	public void limpezaCacheClientes() {
		System.out.println("Limpando cache de clientes");
		cacheManager.getCache("clientes").clear();
	}
	
}
