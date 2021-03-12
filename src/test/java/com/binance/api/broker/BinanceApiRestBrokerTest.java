package com.binance.api.broker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.binance.api.broker.domain.subaccount.DepositHistory;
import com.binance.api.broker.domain.subaccount.InfoResult;
import com.binance.api.broker.domain.subaccount.MarginResult;
import com.binance.api.broker.domain.subaccount.RebateHistoryResult;
import com.binance.api.broker.domain.subaccount.SubAccount;
import com.binance.api.broker.domain.subaccount.SubAccountApiKey;

public class BinanceApiRestBrokerTest {

	final static Logger logger = Logger.getLogger("com.binance.api.broker.BinanceApiRestBrokerTest");
	private static String SUBACCOUNT_OF_TEST = "112648244369075712";
	private static String MASTER_APIKEY = "a7jfB3jNNY2mpGgNJC6SERv3dOPmpGgJZPUE8JcVtffmpGgXoonDJB1j5x2Pph4H";
	private static String MASTER_SECRET = "qxA8LlbRjdnl1HmpGgap07gOJcVt2Y9Yhw5xQyfcmpGgXQDuiBldDKTSqJca7jfB";

	BinanceApiRestBroker binanceApiRestBrokerInstance;
	BinanceApiBrokerFactory brokerFactory;

	@Before
	public void setUp() {
		brokerFactory = BinanceApiBrokerFactory.newInstance(MASTER_APIKEY, MASTER_SECRET);
		binanceApiRestBrokerInstance = brokerFactory.newRestClient();
	}

	@Test
	public void createSubAccountIfNotExists() {
		List<SubAccount> lst = binanceApiRestBrokerInstance.getAllSubAccounts(SUBACCOUNT_OF_TEST, null, null, null,
				System.currentTimeMillis());

		if (lst.size() == 0) {
			logger.info("creating a new subaccount...");
			/*
			 * Object subAccount = binanceApiRestBrokerInstance.newSubAccount(null,
			 * System.currentTimeMillis()); logger.info("subaccount id:" + subAccount);
			 * List<SubAccount> lst2 =
			 * binanceApiRestBrokerInstance.getAllSubAccounts(SUBACCOUNT_OF_TEST, null,
			 * null, null, System.currentTimeMillis()); assertTrue(lst2.size()==1);
			 */
		}

		assertTrue(lst.size() > 0);
	}

	@Test
	public void enableMargin() {
		logger.info("enabling margin for subaccount...");
		MarginResult marginResult = binanceApiRestBrokerInstance.enableMargin(SUBACCOUNT_OF_TEST, null,
				System.currentTimeMillis());
		assertTrue(marginResult.isMarginEnabled());
	}

	/*
	 * @Test public void enableFutures() {
	 * logger.info("enabling futures for subaccount..."); FuturesResult
	 * futuresResult =
	 * binanceApiRestBrokerInstance.enableFutures(SUBACCOUNT_OF_TEST, null,
	 * System.currentTimeMillis()); assertTrue(futuresResult.isFuturesEnabled()); }
	 */

	@Test
	public void createQueryAndDeleteApiKeyForSubAccount() {
		logger.info("creating API/KEY for subaccount...");
		SubAccountApiKey apiKey = binanceApiRestBrokerInstance.newApiKey(SUBACCOUNT_OF_TEST, true, false, false, null,
				System.currentTimeMillis());
		assertTrue(SUBACCOUNT_OF_TEST.equals(apiKey.getSubaccountId()));
		assertTrue(apiKey.getCanTrade());
		assertFalse(apiKey.getMarginTrade());
		assertFalse(apiKey.getFuturesTrade());
		assertTrue(apiKey.getApiKey() != null);
		assertTrue(apiKey.getSecretKey() != null);
		
		List<SubAccountApiKey> apiKeys = binanceApiRestBrokerInstance.getAllApiKeys(SUBACCOUNT_OF_TEST, null, null,
				System.currentTimeMillis());
		
		assertTrue(apiKeys.size()>0);
		
		for (SubAccountApiKey key : apiKeys) {
			logger.info(apiKey.toString());
			binanceApiRestBrokerInstance.deleteApiKey(SUBACCOUNT_OF_TEST, key.getApiKey(), null,
					System.currentTimeMillis());
		}
		
		apiKeys = binanceApiRestBrokerInstance.getAllApiKeys(SUBACCOUNT_OF_TEST, null, null,
				System.currentTimeMillis());
		
		assertTrue(apiKeys.size()==0);
	}

	@Test
	public void testIfSubAccountOfTestExists() {
		List<SubAccount> lst = binanceApiRestBrokerInstance.getAllSubAccounts(null, null, null, null,
				System.currentTimeMillis());

		for (SubAccount subAccount : lst) {
			logger.info("subaccount id:" + subAccount.getSubaccountId());
		}
		int initialSize = lst.size();

		assertTrue(true);
	}

	@Test
	public void testGetInfo() {
		InfoResult infoResult = binanceApiRestBrokerInstance.getInfo(null, System.currentTimeMillis());

		logger.info("info result:" + infoResult.toString());

		assertTrue(infoResult.getMaxSubAccountQty() > 0);
	}

	@Test
	public void testGetAllDepositHistory() {
		List<DepositHistory> lst = binanceApiRestBrokerInstance.getAllDepositHistory(null, null, null, null, null, null, null, null, System.currentTimeMillis());

		for(DepositHistory depositHistory : lst) {
			logger.info("deposit history:" + depositHistory);
		}

		assertTrue(true);
	}
	
	@Test
	public void testGetRecentRebateHistory() {
		List<RebateHistoryResult> lst = binanceApiRestBrokerInstance.getRecentRebateHistory(SUBACCOUNT_OF_TEST, null, null, null, null, null, System.currentTimeMillis());
		
		for(RebateHistoryResult item : lst) {
			logger.info("rebate:" + item.toString());
		}
		
		assertTrue(true);
	}
}
