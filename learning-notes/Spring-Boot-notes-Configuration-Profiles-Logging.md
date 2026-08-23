# Spring Boot Configuration, Profiles & Logging — Quick Revision

## 1. `application.properties`

Spring Boot configuration values ko code se separate rakhne ke liye use hoti hai.

```properties
server.port=8080
app.name=Student Management System
app.version=1.0
```

**Benefits:**
- Configuration code se separate rehti hai.
- Values easily change kar sakte hain.
- Different environments ke liye different configuration rakh sakte hain.

---

## 2. `@Value`

Individual configuration property ko Java class me inject karne ke liye.

```properties
app.name=Student Management System
```

```java
@Value("${app.name}")
private String appName;
```

### Remember

`@Value` → Individual / small properties

```text
application.properties
        ↓
@Value("${app.name}")
        ↓
Java variable
```

---

## 3. `@ConfigurationProperties`

Related configuration properties ke group ko Java object me bind karne ke liye.

```properties
app.name=Student Management System
app.version=1.0
app.author=Keshav
```

```java
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String name;
    private String version;
    private String author;

    // getters & setters
}
```

Mapping:

```text
app.name     → name
app.version  → version
app.author   → author
```

### `@Value` vs `@ConfigurationProperties`

| `@Value` | `@ConfigurationProperties` |
|---|---|
| Individual property | Group of related properties |
| Simple configuration | Structured configuration |
| Small configs | Large/related configs |

**Remember:**

`@Value` → one/few properties

`@ConfigurationProperties` → group of properties

---

# Spring Profiles

Different environments ke liye different configurations maintain karne ke liye Profiles use hote hain.

```text
dev  → Development
test → Testing
prod → Production
```

Files:

```text
application.properties
application-dev.properties
application-test.properties
application-prod.properties
```

### Example

`application-dev.properties`

```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/student_dev
```

`application-prod.properties`

```properties
server.port=8080
spring.datasource.url=jdbc:mysql://prod-server:3306/student_prod
```

### Activate Profile

```properties
spring.profiles.active=dev
```

Spring then uses:

```text
application.properties
        +
application-dev.properties
```

---

## `@Profile`

Kisi bean ko specific profile ke liye activate karne ke liye.

```java
@Component
@Profile("dev")
public class DevDataLoader {
}
```

Ye bean sirf `dev` profile active hone par create hogi.

### Remember

`Profiles` → Environment-specific configuration

`@Profile` → Environment-specific bean

### Real-world Structure

```text
Developer
    ↓
dev profile
    ↓
Local Database

Testing
    ↓
test profile
    ↓
Test Database

Production
    ↓
prod profile
    ↓
Production Database
```

Same application code, different environment configuration.

**Best practice:** Production passwords/API keys ko GitHub me directly commit nahi karna. Environment variables / secrets management use karna.

---

# Logging / SLF4J

## Logging

Application me kya ho raha hai usko record karna = Logging.

Avoid:

```java
System.out.println("Student added");
```

Prefer:

```java
logger.info("Student added successfully");
```

---

## SLF4J

**SLF4J = Simple Logging Facade for Java**

Ye Java ke liye logging abstraction/facade provide karta hai.

```java
private static final Logger logger =
        LoggerFactory.getLogger(StudentService.class);
```

Usage:

```java
logger.info("Student added successfully");
```

---

## Log Levels

```text
TRACE
DEBUG
INFO
WARN
ERROR
```

### INFO
Normal application information.

```java
logger.info("Student created with ID {}", id);
```

### DEBUG
Development/debugging information.

```java
logger.debug("Request received for student ID {}", id);
```

### WARN
Potential problem.

```java
logger.warn("Student ID {} does not exist", id);
```

### ERROR
Actual error/exception.

```java
logger.error("Failed to create student", ex);
```

---

## Parameterized Logging

Prefer:

```java
logger.info("Student ID: {}", id);
```

Instead of:

```java
logger.info("Student ID: " + id);
```

Multiple values:

```java
logger.info(
    "Student {} enrolled in course {}",
    studentId,
    courseId
);
```

---

## Exception Logging

Better:

```java
logger.error(
    "Failed to fetch student with ID {}",
    id,
    ex
);
```

This logs the message along with the exception/stack trace.

---

# ⭐ Interview Quick Revision

### `@Value`
Individual configuration property inject karta hai.

### `@ConfigurationProperties`
Related/grouped configuration properties ko Java object me bind karta hai.

### Spring Profiles
Environment-specific configurations aur beans manage karne ke liye.

### `@Profile`
Specific profile active hone par bean ko load karta hai.

### SLF4J
Java ke liye logging facade/abstraction.

### Common Log Levels

```text
TRACE → DEBUG → INFO → WARN → ERROR
```

### Logger vs `System.out.println()`

Logger better hai because it provides:
- Log levels
- Configurable output
- Context
- Production-friendly logging
- Exception/stack-trace logging

---

# ⭐ One-Minute Revision

```text
application.properties
        ↓
Configuration

@Value
        ↓
Individual property

@ConfigurationProperties
        ↓
Group of properties

Profiles
        ↓
dev / test / prod

@Profile
        ↓
Profile-specific bean

SLF4J
        ↓
Application logging

INFO  → Normal information
DEBUG → Debugging
WARN  → Potential problem
ERROR → Actual error
```
