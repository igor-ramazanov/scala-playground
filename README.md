# scala-playground

Fails with:
```
sbt:scala-playground> compile
[error] stack trace is suppressed; run last Compile / smithy4sCodegen for the full output
[error] (Compile / smithy4sCodegen) software.amazon.smithy.model.validation.ValidatedResultException: Result contained ERROR severity validation events:
[error] [ERROR] com.amazonaws.dynamodb#DynamoDB_20120810: Unable to resolve trait `smithy.rules#endpointRuleSet`. If this is a custom trait, then it must be defined before it can be used in a model. | Model /home/igor/personal/scala-playground/src/main/smithy/dynamodb.json:3401:41
[error] [ERROR] com.amazonaws.dynamodb#DynamoDB_20120810: Unable to resolve trait `smithy.rules#endpointTests`. If this is a custom trait, then it must be defined before it can be used in a model. | Model /home/igor/personal/scala-playground/src/main/smithy/dynamodb.json:3765:39
[error] Total time: 1 s, completed Dec 13, 2022, 1:40:19 PM
```
