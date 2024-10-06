rootProject.name = "multi-module"
include(
    "domain",
    "order-api",
    "infrastructure:h2-db",
    "boot-payment-api"
)
