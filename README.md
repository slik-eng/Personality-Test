# Android MVP + Dagger2 + Dagger-Android
### Summary
This sample is based on the MutipleChoice-MVP project and uses Dagger to externalize the creation of dependencies from the classes that use them.

### Key concepts
[Dagger2](http://google.github.io/dagger/) is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square and now maintained by Google.

[Dagger-Android](https://google.github.io/dagger//android.html) are Android specific helpers for Android, specifically the auto generation of sub components using a new code generator.

This sample is still using the mock/prod flavors from todo-mvp to generate different APKs. There is a InterActorModule in prod/ which fetches data from the slow data source (simulating a backend API) and another one in mock/, which provides fake data, ideal for automated testing. With this approach the app can be configured to use fake location coordinates, write and read from fake shared preferences, simulate network conditions, etc.

### Dependencies
 
 * Dagger2
## Features

### Complexity - understandability

#### Use of architectural frameworks/libraries/tools:

Building an app with a dependency injection framework is not trivial as it uses new concepts and many operations are done under the hood. However, once in place, it's not hard to understand and use.

### Testability

Very high. Use of Dagger2 improves flexibility in local integration tests and UI tests. Components can be replaced by doubles very easily and test different scenarios.

### Maintainability

#### Ease of amending or adding a feature + Learning cost

Medium. Developers need to be aware of how Dagger2 works, although the setup of new features should look very similar to existing ones.  Once Dagger is setup within an app it is no more difficult to add a new feature than without it.
