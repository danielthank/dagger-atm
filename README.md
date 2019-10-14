ATM CLI - dagger tutorial
=====
This repo rewrites the tutorial https://dagger.dev/tutorial/ in Kotlin for studying kotlin and dagger concept. 

Study note
=====
- `@Component` tells Dagger to implement an interface or abstract class that creates and returns one or more application objects.
Dagger will generate a class that implements the component type. The generated type will be named `DaggerYourType` (or `DaggerYourType_NestedType` for nested types)
- `@Inject` on a constructor tells Dagger how to instantiate that class.
- Parameters to an `@Inject` constructor are the dependencies of the class. Dagger will provide a class’s dependencies to instantiate the class itself. Note that this is recursive: a dependency may have dependencies of its own!
- `@Modules` are classes or interfaces that act as collections of instructions for Dagger on how to construct dependencies. They’re called modules because they are modular: you can mix and match modules in different applications and contexts.
- `@Binds` methods are one way to tell Dagger how to construct an instance. They are abstract methods on modules that associate one type that Dagger already knows how to construct (the method’s parameter) with a type that Dagger doesn’t yet know how to construct (the method’s return type).
- `@Provides` methods are concrete methods in a module that tell Dagger that when something requests an instance of the type the method returns, it should call that method to get an instance. Like @Inject constructors, they can have parameters: those parameters are their dependencies.
  - `@Provides` methods can contain arbitrary code as long as they return an instance of the provided type. They do not need to create a new instance on each invocation.
    This highlights an important aspect of Dagger (and dependency injection as a whole): when a type is requested, whether or not a new instance is created to satisfy that request is an implementation detail. Going forward, we’ll use the term “provided” instead of “created”.