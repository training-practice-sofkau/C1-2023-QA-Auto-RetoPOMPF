package com.sofkau.setup;

import io.restassured.RestAssured;

public class ConstantsSetup {
    public static final String BASE_URL = "https://api.coingecko.com/";
    public static final String VALID_EXCHANGES_ID = "api/v3/exchanges/binance";
    public static final String EXCHANGE_NAME = "Binance";
    public static final String INVALID_EXCHANGE_ID = "api/v3/exchanges/chechocrypto";

    public static final String VALID_PUBLIC_COMPANIES_ID = "api/v3/companies/public_treasury/bitcoin";
    public static final String INVALID_PUBLIC_COMPANIES_ID = "api/v3/companies/public_treasury/chechocoin";

}
