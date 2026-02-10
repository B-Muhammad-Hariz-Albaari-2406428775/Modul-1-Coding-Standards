# Reflection 1

## Clean Code Principles Applied

During the implementation of the Edit and Delete Product features, several clean code principles were applied:

### 1. Single Responsibility Principle (SRP)

Each layer has a clear and focused responsibility:

* **Controller**: Handles HTTP requests and response mapping.
* **Service**: Contains business logic abstraction.
* **Repository**: Manages data operations.
* **Model**: Represents the domain entity.

> This separation improves maintainability and readability.

### 2. Layered Architecture (Separation of Concerns)

The project follows a clear layered architecture:
`Controller` > `Service` > `Repository` > `Model`

This prevents tight coupling between components and makes future improvements (e.g., database integration) easier.

### 3. Meaningful Naming

* **Methods**: `create`, `findAll`, `findById`, `update`, and `delete` clearly describe their behavior.
* **Variables**: Names like `productRepository`, `allProducts`, and `productData` are self-explanatory.
* This reduces the need for excessive comments.

### 4. Small and Focused Methods

Each method performs a single well-defined task:

* **Controller** methods only handle routing and delegation.
* **Repository** methods only manipulate the data structure.
* **Service** methods coordinate between layers.

### 5. Avoiding Code Duplication

The edit and delete logic reuse existing service and repository structures without duplicating logic in the controller.

---

## Secure Coding Practices Applied

1. **Encapsulation**
   The `Product` model uses Lombok's `@Getter` and `@Setter`, ensuring fields remain private and controlled through accessors.
3. **No Direct Data Exposure**
   The repository does not expose the internal `List<Product>` directly. Instead, it returns an `Iterator` or controlled access through service methods, reducing the risk of unintended modifications.

---

## Identified Improvements

Although the implementation works correctly, several improvements can be made:

* **Null Handling** : Methods like `findById` return `null` if the product is not found, which can cause `NullPointerException`.
* *Improvement*: Use `Optional<Product>` and add validation in the controller.


* **Validation** : Currently, there is no validation for empty product names, negative quantities, or duplicate IDs.
* *Improvement*: Use `@Valid` and annotations such as `@NotBlank` and `@Min(0)`.


* **In-Memory Storage Limitation** : The repository uses an `ArrayList`, meaning data is lost on restart and lacks concurrency handling.
* *Improvement*: Integrate with a database.



---

## Conclusion

The implementation follows clean architecture principles and demonstrates proper separation of concerns. The code is readable, modular, and extensible. However, improvements in input validation, null safety, and persistence integration are necessary to reach production-level quality.

This exercise helped reinforce clean code practices, layered architecture design, and basic secure coding principles in **Spring Boot** applications.

---

# Reflection 2

1. **Code Coverage vs. Code Quality** Having 100% code coverage does not guarantee that the code is free of bugs or errors. Code coverage only reflects that every line of code was executed during testing; it does not verify that the logic is correct or that all possible edge cases (e.g., negative inputs, missing fields) are handled properly.

2. **Clean Code in Functional Tests** Creating a new functional test class with the exact same setup procedures and instance variables (serverPort, testBaseUrl, baseUrl) as the previous test suites violates the DRY (Don't Repeat Yourself) principle. This duplication lowers code quality and makes maintenance difficult.

Improvement: To fix this, I should create a BaseFunctionalTest class that handles the common setup configuration. All specific functional test classes (like CreateProductFunctionalTest and HomePageFunctionalTest) should extend this base class. This removes code duplication and keeps the test files clean and focused on their specific logic.