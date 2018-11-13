package com.trading.tradingview.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trading.tradingview.entity.TradeData;
import com.trading.tradingview.enums.TradeType;
import com.trading.tradingview.exception.TradingViewException;
import com.trading.tradingview.repo.TradingRepository;
import com.trading.tradingview.service.TradingService;

@Service("tradingService")
public class TradingServiceImpl implements TradingService {
	
	Logger logger = LoggerFactory.getLogger(TradingServiceImpl.class);
	
	@Autowired
	TradingRepository repository;
	
	/**
	 * Access all Trading Data
	 */
	@Override
	public String getAllTradingData() throws TradingViewException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			List<TradeData> list = repository.findAll().stream().collect(Collectors.toList());
			List<TradeData> buylist = list.stream().filter(d -> d.getSide().equals(TradeType.BUY))
					.collect(Collectors.toList());
			List<TradeData> selllist = list.stream().filter(d -> d.getSide().equals(TradeType.SELL))
					.collect(Collectors.toList());
			Map<String, List<TradeData>> result = new HashMap<>();
			result.put("buyOrders", buylist);
			result.put("sellOrders", selllist);

			jsonResponse = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			logger.error("Error in JSON Parsing {}", e.getMessage());
			throw new TradingViewException("JSON parsing Error in extracting trading data");
		} catch (Exception e) {
			logger.error("Error Data Accesss {}", e.getMessage());
			throw new TradingViewException("Error in accessing trading data from Database");
		}
		return jsonResponse;
	}
	
	/**
	 * Save Trading Data
	 */
	@Override
	public String addTradeData(TradeData trade) throws TradingViewException {
		try {
			repository.save(trade);
		} catch (Exception e) {
			logger.error("Error Data Save {}", e.getMessage());
			throw new TradingViewException("Error in saving trading data in Database");
		}
		return "Successfully Data Saved !!";
	}

}
