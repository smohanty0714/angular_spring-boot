package com.trading.tradingview.service;

import com.trading.tradingview.entity.TradeData;
import com.trading.tradingview.exception.TradingViewException;


public interface TradingService {
	/**
	 * 
	 * @return
	 * @throws TradingViewException
	 */
	public String getAllTradingData() throws TradingViewException;
	
	/**
	 * 
	 * @param trade
	 * @return
	 * @throws TradingViewException
	 */
	public String addTradeData(TradeData trade) throws TradingViewException;
}
