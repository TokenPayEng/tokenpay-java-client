# TokenPay Java Client

[![Build Status](https://github.com/TokenPayEng/tokenpay-java-client/workflows/TokenPay%20Java%20CI/badge.svg)](https://github.com/TokenPayEng/tokenpay-java-client/actions)

This repo contains the Java client for TokenPay API.

## Requirements
- Java 1.8 or newer

## Installation
Apache Maven:
```bash
<dependency>
  <groupId>tr.com.tokenpay</groupId>
  <artifactId>tokenpay</artifactId>
  <version>0.0.4</version>
</dependency>
```
Gradle Groovy DSL
```
implementation 'tr.com.tokenpay:tokenpay:0.0.4'
```
Gradle Kotlin DSL
```
implementation("tr.com.tokenpay:tokenpay:0.0.4")
```

## Usage
To access the TokenPay API you'll first need to obtain API credentials (e.g. an API key and a secret key). If you don't already have a TokenPay account, you can signup at [https://tokenpay.com.tr/](https://tokenpay.com.tr)

Once you've obtained your API credentials, you can start using TokenPay by instantiating a `TokenPay` with your credentials.

```java

TokenPay tokenPay = new TokenPay("<YOUR API KEY>", "<YOUR SECRET KEY>");
...

```

By default the TokenPay client connects to the production API servers at `https://api.tokenpay.com.tr`. For testing purposes, please use the sandbox URL `https://sandbox-api.tokenpay.com.tr` using the .

```java

TokenPay tokenPay = new TokenPay("<YOUR API KEY>", "<YOUR SECRET KEY>", "https://sandbox-api.tokenpay.com.tr");
...

```

## Examples
Included in the project are a number of examples that cover almost all use-cases. Refer to [the `sample/` folder](./src/test/java/tr/com/tokenpay/sample)] for more info.

### Running the Examples
If you've cloned this repo on your development machine and wish to run the examples you can run an example with the command `./gradlew test` or run single test with the command `./gradlew test --tests PaymentSample.create_payment_sample`

### Credit Card Payment Use Case
Let's quickly review an example where we implement a credit card payment scenario.

> For more examples covering almost all use-cases, check out the [examples in the `sample/` folder](./src/test/java/tr/com/tokenpay/sample)

```java
TokenPay tokenPay = new TokenPay("api-key", "secret-key", "http://localhost:8000");

List<PaymentItem> items = new ArrayList<>();

items.add(PaymentItem.builder()
        .name("item 1")
        .externalId("sfdsdf")
        .price(BigDecimal.valueOf(30))
        .subMerchantId(1L)
        .subMerchantPrice(BigDecimal.valueOf(27))
        .build());

items.add(PaymentItem.builder()
        .name("item 2")
        .externalId("cvbxcvb")
        .price(BigDecimal.valueOf(50))
        .subMerchantId(2L)
        .subMerchantPrice(BigDecimal.valueOf(42))
        .build());

items.add(PaymentItem.builder()
        .name("item 3")
        .externalId("vmvcx")
        .price(BigDecimal.valueOf(20))
        .subMerchantId(3L)
        .subMerchantPrice(BigDecimal.valueOf(18))
        .build());

CreatePaymentRequest request = CreatePaymentRequest.builder()
        .price(BigDecimal.valueOf(100))
        .paidPrice(BigDecimal.valueOf(100))
        .walletPrice(BigDecimal.ZERO)
        .installment(1)
        .currency(Currency.TRY)
        .conversationId("asdjasdjasdfjhasd")
        .paymentGroup(PaymentGroup.PRODUCT)
        .paymentPhase(PaymentPhase.AUTH)
        .card(Card.builder()
                .cardHolderName("Pharmacy User")
                .cardNumber("5406670000000009")
                .expireYear("2035")
                .expireMonth("11")
                .cvc("123")
                .build())
        .items(items)
        .build();

PaymentResponse paymentResponse = tokenPay.payment().createPayment(request);
System.out.println(String.format("Create Payment Result: %s", paymentResponse));
```

### Advanced Usage: Adapters
In reality, the `TokenPay` class serves as a collection of adapters that integrates with different parts of the API. While the intended usage for most use-cases is to instantiate a `TokenPay` instance (as illustrated in the examples above) and use its adapter accessors (e.g. `payment()`), you can also manually import a certain adapter class and instantiate it.

**Note:** When instantiating an adapter, you can use the same options as you would when instantiating a `TokenPay`

For all adapters in the `TokenPay`, their purposes, accessors, as well as direct import paths, refer to the list below:

| Adapter Name | Purpose | Accessor |
|--------------|---------|----------|
| `InstallmentAdapter` | Retrieving per-installment pricing information based on installment count or BIN number | `installment()` |
| `OnboardingAdapter` | Conducting CRUD operations on buyers and submerchants | `onboarding()` |
| `PaymentAdapter` | Conducting payments, retrieving payment information, managing stored cards | `payment()` |
| `SettlementReportingAdapter` | Retrieving information on settlements | `settlementReporting()` |

## License
MIT
