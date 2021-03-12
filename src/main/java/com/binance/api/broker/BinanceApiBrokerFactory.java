package com.binance.api.broker;

import com.binance.api.broker.impl.BinanceApiRestBrokerImpl;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceApiBrokerFactory {

  /**
   * API Key
   */
  private String apiKey;

  /**
   * Secret.
   */
  private String secret;

  /**
   * Instantiates a new binance api client factory.
   *
   * @param apiKey the API key
   * @param secret the Secret
   */
  private BinanceApiBrokerFactory(String apiKey, String secret) {
    this.apiKey = apiKey;
    this.secret = secret;
  }

  /**
   * New instance.
   *
   * @param apiKey the API key
   * @param secret the Secret
   *
   * @return the binance api client factory
   */
  public static BinanceApiBrokerFactory newInstance(String apiKey, String secret) {
    return new BinanceApiBrokerFactory(apiKey, secret);
  }

  /**
   * New instance without authentication.
   *
   * @return the binance api client factory
   */
  public static BinanceApiBrokerFactory newInstance() {
    return new BinanceApiBrokerFactory(null, null);
  }

  /**
   * Creates a new synchronous/blocking REST client.
   */
  public BinanceApiRestBroker newRestClient() {
    return new BinanceApiRestBrokerImpl(apiKey, secret);
  }

//  /**
//   * Creates a new asynchronous/non-blocking REST client.
//   */
//  public BinanceApiAsyncRestBroker newAsyncRestClient() {return new BinanceApiAsyncRestBrokerImpl(apiKey, secret);
//  }
//
//  /**
//   * Creates a new web socket client used for handling data streams.
//   */
//  public BinanceApiWebSocketBroker newWebSocketClient() {
//    return new BinanceApiWebSocketBrokerImpl(getSharedClient());
//  }
}
