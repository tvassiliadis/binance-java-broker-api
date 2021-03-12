package com.binance.api.broker.exception;

import java.util.logging.Logger;

import com.binance.api.broker.BinanceApiBrokerError;

/**
 * An exception which can occur while invoking methods of the Binance API.
 */
public class BinanceApiBrokerException extends RuntimeException {
	
	final static Logger logger = Logger.getLogger("com.binance.api.broker.BinanceApiException");

	private static final long serialVersionUID = 3788669840036201041L;
	/**
	 * Error response object returned by Binance API.
	 */
	private BinanceApiBrokerError error;

	/**
	 * Instantiates a new binance api exception.
	 *
	 * @param error an error response object
	 */
	public BinanceApiBrokerException(BinanceApiBrokerError error) {
		logger.severe(error.getMsg());
		this.error = error;
	}

	/**
	 * Instantiates a new binance api exception.
	 */
	public BinanceApiBrokerException() {
		super();
	}

	/**
	 * Instantiates a new binance api exception.
	 *
	 * @param message the message
	 */
	public BinanceApiBrokerException(String message) {
		super(message);
		logger.severe(message);
	}

	/**
	 * Instantiates a new binance api exception.
	 *
	 * @param cause the cause
	 */
	public BinanceApiBrokerException(Throwable cause) {
		super(cause);
		logger.severe(cause.getMessage());
	}

	/**
	 * Instantiates a new binance api exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public BinanceApiBrokerException(String message, Throwable cause) {
		super(message, cause);
		logger.severe(message);
	}

	/**
	 * @return the response error object from Binance API, or null if no response
	 *         object was returned (e.g. server returned 500).
	 */
	public BinanceApiBrokerError getError() {
		return error;
	}

	@Override
	public String getMessage() {
		if (error != null) {
			return error.getMsg();
		}
		return super.getMessage();
	}
}
