# Java-Practice

## Where Java Records Should Be Used

Java records are ideal for:
- **Data Transfer Objects (DTOs)** - Immutable data containers for moving data between layers
- **Value Objects** - Representing values with no identity, like coordinates or amounts
- **API Response/Request Models** - Lightweight models for JSON serialization
- **Immutable Collections** - Safe data structures that cannot be modified after creation
- **Pattern Matching** - Records work well with Java's pattern matching features
- **Simple Data Aggregates** - Small, focused classes that just hold and carry data
- **Caching Keys** - Immutable objects that can be used as map keys or set members

## Where Java Records Should NOT Be Used

- **JPA Entities** - ORM frameworks expect mutable classes with default constructors
- **Mutable Domain Models** - When objects need to change state after creation
- **Objects with Identity or Lifecycles** - When object equality should be based on identity, not values
- **Classes Requiring Inheritance** - Records do not allow `extends` or `implements` (compile-time error)
- **Business-Logic-Heavy Classes** - When complex behavior and methods are needed
- **Classes Requiring Serialization** - Some serialization frameworks may not work well with records

## Canonical Constructors and Compact Constructors

### Canonical Constructor
The canonical constructor is the explicit constructor that initializes all fields of a record. It matches the record's components exactly.

```java
public record Point(int x, int y) {
    // Canonical Constructor - explicitly declaring the same constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

### Compact Constructor
A compact constructor is a concise way to write the canonical constructor without explicitly declaring parameter types. It automatically assigns parameters to their corresponding fields.

```java
public record Point(int x, int y) {
    // Compact Constructor - shorter syntax
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative");
        }
        // No need to write this.x = x; this.y = y; - automatic assignment
    }
}
```

**Key Differences:**
- **Canonical Constructor** - Full declaration with parameter types and explicit field assignments
- **Compact Constructor** - Shorter syntax using implicit field assignments; useful for validation logic
- Both achieve the same goal but compact constructors are more concise and readable for simple validations
