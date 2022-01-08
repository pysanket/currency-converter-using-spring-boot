# Currency Converter Using Spring-Boot

This api is built on spring boot and it can convert all the currencies to your preferred currency.

## Features

 1. Support 40+ currency.
 2. Built on spring-boot.

## Endpoints
  1. {{hostname}}/currency/convertor/{YourCurrency}/{ConvertTo}/{Amount} :- This  endpoint will give exact amount when converted to desired currency.
  2. {{hostname}}/currency/convertor/{YourCurrency} :- This endpoint can covert your input currency to all the currencies (base amount for conversion is 1).
  
 ## Sample Responses
 1. {{hostname}}/currency/convertor/{YourCurrency}/{ConvertTo}/{Amount}
 ```diff
  - 50000.0 INR to USD is -> 673.2.
 ```
 2. {{hostname}}/currency/convertor/{YourCurrency}
 ```json
 {
    "query": {
        "apikey": "1e4eb930-6f1a-11ec-9970-6bb59e3e4f51",
        "base_currency": "USD",
        "timestamp": 1641666289
    },
    "data": {
        "JPY": 115.53171,
        "CNY": 6.38214,
        "CHF": 0.91836,
        "CAD": 1.2644,
        "MXN": 20.36608,
        "INR": 74.2718,
        "BRL": 5.63562,
        "RUB": 75.66346,
        "KRW": 1197.81628,
        "IDR": 14355.37081,
        "TRY": 13.86265,
        "SAR": 3.75287,
        "SEK": 9.04639,
        "NGN": 412.96507,
        "PLN": 3.99857,
        "ARS": 103.28198,
        "NOK": 8.82506,
        "TWD": 27.6008,
        "IRR": 42001.24249,
        "AED": 3.67268,
        "COP": 4047.14152,
        "THB": 33.61099,
        "ZAR": 15.55375,
        "DKK": 6.54637,
        "MYR": 4.2071,
        "SGD": 1.35483,
        "ILS": 3.10007,
        "HKD": 7.79669,
        "EGP": 15.67018,
        "PHP": 51.32078,
        "CLP": 827.34414,
        "PKR": 176.55256,
        "IQD": 1458.51541,
        "DZD": 138.80287,
        "KZT": 435.28597,
        "QAR": 3.6401,
        "CZK": 21.50744,
        "PEN": 3.9193,
        "RON": 4.34969,
        "VND": 22685.45634,
        "BDT": 85.69159,
        "HUF": 315.00623,
        "UAH": 27.47067,
        "AOA": 550.01272,
        "MAD": 9.25572,
        "OMR": 0.38491,
        "CUC": 24.00066,
        "BYR": 3.00008,
        "AZN": 1.69505,
        "LKR": 202.75318,
        "SDG": 436.29174,
        "SYP": 2510.0356,
        "MMK": 1769.54511,
        "DOP": 57.46141,
        "UZS": 10780.28138,
        "KES": 113.20251,
        "GTQ": 7.71316,
        "URY": 44.73077,
        "HRV": 6.61999,
        "MOP": 8.0292,
        "ETB": 49.21074,
        "CRC": 639.88429,
        "TZS": 2302.03829,
        "TMT": 3.49007,
        "TND": 2.87756,
        "PAB": 1.00002,
        "LBP": 1505.51706,
        "RSD": 103.40152,
        "LYD": 4.58796,
        "GHS": 6.05014,
        "YER": 250.00336,
        "BOB": 6.8202,
        "BHD": 0.37701,
        "CDF": 1994.93942,
        "PYG": 6930.57265,
        "UGX": 3535.07423,
        "SVC": 8.75004,
        "TTD": 6.76571,
        "AFN": 104.92294,
        "NPR": 118.89163,
        "HNL": 24.32043,
        "BIH": 1.72153,
        "BND": 1.35554,
        "ISK": 128.51284,
        "KHR": 4065.04501,
        "GEL": 3.06857,
        "MZN": 63.18072,
        "BWP": 11.6744,
        "PGK": 3.51186,
        "JMD": 153.46231,
        "XAF": 578.10305,
        "NAD": 15.55037,
        "ALL": 106.50135,
        "SSP": 431.68547,
        "MUR": 43.55073,
        "MNT": 2830.06279,
        "NIO": 35.48086,
        "LAK": 11250.23941,
        "MKD": 54.14125,
        "AMD": 481.70264,
        "MGA": 3920.04668,
        "XPF": 105.00199,
        "TJS": 11.29022,
        "HTG": 98.58234,
        "BSD": 1.00003,
        "MDL": 17.83723,
        "RWF": 1000.21638,
        "KGS": 84.80194,
        "GNF": 9090.202,
        "SRD": 21.06442,
        "SLL": 11290.2195,
        "XOF": 577.01439,
        "MWK": 809.11787,
        "FJD": 2.13476,
        "ERN": 15.05024,
        "SZL": 15.55023,
        "GYD": 207.98528,
        "BIF": 1991.23156,
        "KYD": 0.82501,
        "MVR": 15.42017,
        "LSL": 15.63671,
        "LRD": 145.5037,
        "CVE": 97.30136,
        "DJF": 177.50513,
        "SCR": 14.60941,
        "SOS": 575.01237,
        "GMD": 52.70144,
        "KMF": 434.19106,
        "STD": 21.5704,
        "XRP": 1.31003,
        "AUD": 1.39272,
        "BGN": 1.72404,
        "BTC": 0.0239,
        "JOD": 0.70702,
        "GBP": 0.73551,
        "ETH": 0.00031,
        "EUR": 0.88021,
        "LTC": 0.01,
        "NZD": 1.47643
    }
}