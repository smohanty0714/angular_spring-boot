package com.trading.tradingview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trading.tradingview.entity.TradeData;
import com.trading.tradingview.exception.TradingViewException;
import com.trading.tradingview.service.TradingService;

@RestController
public class TradeViewController {

	@Autowired
	@Qualifier("tradingService")
	private TradingService tradingService;
	
	@RequestMapping(path = "/market/orderbook", method = RequestMethod.GET, produces={"application/json"})
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> getTradeData() {
		try {
			return ResponseEntity.ok(tradingService.getAllTradingData());
		} catch (TradingViewException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@RequestMapping(path = "/market/placeOrder", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> saveTradeData(@RequestBody TradeData data) {
		try {
			return ResponseEntity.ok(tradingService.addTradeData(data));
		} catch (TradingViewException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
