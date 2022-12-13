# scala-playground

Fails with:
```
sbt:scala-playground> compile
...
[error]  found   : Double(0.0)
[error]  required: Float
[error] case class ReservedInstancesOffering(duration: Long = 0, fixedPrice: Float = 0.0, usagePrice: Float = 0.0, marketplace: Boolean = false, availabilityZone: Option[String] = None, instanceType: Option[InstanceType] = None, productDescription: Option[RIProductDescription] = None, reservedInstancesOfferingId: Option[String] = None, currencyCode: Option[CurrencyCodeValues] = None, instanceTenancy: Option[Tenancy] = None, offeringClass: Option[OfferingClassType] = None, offeringType: Option[OfferingTypeValues] = None, pricingDetails: Option[List[PricingDetail]] = None, recurringCharges: Option[List[RecurringCharge]] = None, scope: Option[Scope] = None)
...
```
