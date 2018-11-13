package com.trading.tradingview;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.trading.tradingview.entity.TradeData;
import com.trading.tradingview.enums.TradeType;
import com.trading.tradingview.repo.TradingRepository;

@SpringBootApplication
public class TradingviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingviewApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(TradingRepository repository) {
        return args -> {
            Stream.of("BUY:5:21", "BUY:10:20", "BUY:10:19", "SELL:23:10", "SELL:26:5").forEach(data -> {
                String[] tradeData = data.split(":");
                TradeData trade = new TradeData();
          
                trade.setSide(TradeType.valueOf(tradeData[0]));
                trade.setVolume(Integer.parseInt(tradeData[1]));
                trade.setPrice(BigDecimal.valueOf(Long.valueOf(tradeData[2])));
                repository.save(trade);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
