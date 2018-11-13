package com.trading.tradingview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.trading.tradingview.entity.TradeData;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface TradingRepository extends JpaRepository<TradeData, Long> {

}
