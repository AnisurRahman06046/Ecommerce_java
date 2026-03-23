# E-Commerce System — Design Patterns in Java

A modular e-commerce application built to demonstrate five core design patterns through a realistic order processing workflow.

## Design Patterns

| Pattern | Module | Purpose |
|---------|--------|---------|
| **Strategy** | Payment, Notification | Swap payment methods and notification channels at runtime |
| **Factory** | Payment | Create payment strategy instances from a type string |
| **State** | Order | Enforce valid order lifecycle transitions |
| **Decorator** | Discount | Compose and stack multiple discounts |
| **Strategy + Decorator** | Promotion | Combine promotions into a single chained discount |

## Project Structure

```
ecommerce/
├── main/
│   └── Main.java                  # Entry point — runs the full workflow
├── payment/
│   ├── PaymentStrategy.java       # Strategy interface
│   ├── PaymentFactory.java        # Factory for creating strategies
│   ├── CreditCardPayment.java
│   ├── PayPalPayment.java
│   └── CryptoPayment.java
├── order/
│   ├── Order.java                 # State context
│   ├── OrderState.java            # State interface
│   ├── PendingState.java          # Pending → can pay
│   ├── PaidState.java             # Paid → can ship
│   └── ShippedState.java          # Shipped → can deliver
├── discount/
│   ├── Discount.java              # Discount interface
│   ├── PercentageDiscount.java    # e.g. 25% off
│   ├── FlatDiscount.java          # e.g. $30 off
│   └── DiscountDecorator.java     # Chains multiple discounts
├── promotion/
│   ├── Promotion.java             # Promotion interface
│   ├── PromotionEngine.java       # Manages & combines promotions
│   ├── BlackFridayPromotion.java  # 25% discount
│   └── LoyaltyPromotion.java     # $30 flat discount
└── notification/
    ├── NotificationStrategy.java  # Strategy interface
    ├── NotificationService.java   # Context / dispatcher
    ├── EmailNotification.java
    └── SMSNotification.java
```

## Application Flow

```
Create Order ($299.99)
    │
    ▼
PromotionEngine combines BlackFriday (25%) + Loyalty ($30)
    │
    ▼
DiscountDecorator applies chained discount → final amount
    │
    ▼
PaymentFactory selects CreditCardPayment → processes payment
    │
    ▼
Order state transitions: Pending → Paid → Shipped → Delivered
    │
    ▼
NotificationService sends Email + SMS confirmations
```

## How to Run

```bash
# Compile all sources
javac -d . ecommerce/**/*.java

# Run
java ecommerce.main.Main
```

## Modules

### Payment (Strategy + Factory)
`PaymentFactory.getPayment(type, detail)` returns the right `PaymentStrategy` implementation. Supported types: `"CC"` / `"CREDITCARD"`, `"PP"` / `"PAYPAL"`, `"CRYPTO"`.

### Order (State)
`Order` delegates `payOrder()`, `shipOrder()`, and `deliverOrder()` to its current `OrderState`. Invalid transitions (e.g. shipping before payment) are rejected by each state.

### Discount (Decorator)
`DiscountDecorator` wraps a list of `Discount` objects and applies them sequentially, allowing percentage and flat discounts to be freely combined.

### Promotion
`PromotionEngine` collects active `Promotion` instances, converts each to a `Discount`, and merges them via `DiscountDecorator`.

### Notification (Strategy)
`NotificationService` accepts any `NotificationStrategy` (Email or SMS) and delegates message delivery.

Creation problem        → Factory
Algorithm switching     → Strategy
Add behavior dynamically→ Decorator
Event system            → Observer
Compatibility layer     → Adapter
Action as object        → Command
Hierarchical structure  → Composite