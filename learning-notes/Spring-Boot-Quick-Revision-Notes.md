# Spring Boot — Quick Revision Notes

## Exception Handling

### Core Annotations
- `@ExceptionHandler` → specific exception ko handle karta hai.
- `@ControllerAdvice` → multiple controllers ke liye global exception handling.

**Flow:** `Exception → @ControllerAdvice → @ExceptionHandler → ErrorResponse → HTTP Status`

### Custom Exception

```java
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
```

Usage:

```java
studentRepo.findById(id)
    .orElseThrow(() ->
        new StudentNotFoundException(
            "Student with ID " + id + " not found"
        )
    );
```

### Global Exception Handler

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(
            StudentNotFoundException ex) {
        // return 404
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex) {
        // return 500
    }
}
```

- Specific handler → specific exception
- `Exception.class` → generic/fallback handler

### Validation Exception

DTO:

```java
@NotBlank(message = "Name is required")
private String name;

@Min(value = 18, message = "Age must be atleast 18")
private Integer age;
```

Controller:

```java
public ResponseEntity<?> addStudent(
        @Valid @RequestBody StudentRequestDTO requestDTO)
```

Invalid request → `MethodArgumentNotValidException`

Useful methods:

```java
ex.getBindingResult()
ex.getBindingResult().getFieldErrors()
error.getField()
error.getDefaultMessage()
```

Example response:

```json
{
  "name": "Name is required",
  "age": "Age must be atleast 18"
}
```

### Important HTTP Status Codes

- `400` → Bad Request / Validation Error
- `404` → Resource Not Found
- `500` → Internal Server Error

### ErrorResponse

Consistent API error structure:

```text
status
message
timestamp
```

Example:

```json
{
  "status": 404,
  "message": "Student with ID 999 not found",
  "timestamp": "2026-08-21T18:00:00"
}
```

### Interview Quick Questions

**Q. `@ExceptionHandler`?**  
Specific exception handle karta hai.

**Q. `@ControllerAdvice`?**  
Global/centralized exception handling.

**Q. `MethodArgumentNotValidException`?**  
`@Valid` request validation fail hone par aati hai.

**Q. Custom Exception kyu?**  
Application-specific errors ko clearly represent aur handle karne ke liye.

**Q. Generic Exception handler?**  
Unexpected exceptions ke liye fallback.

### ⭐ Remember

```text
@Valid
  ↓
Validation fails
  ↓
MethodArgumentNotValidException
  ↓
@ControllerAdvice
  ↓
@ExceptionHandler
  ↓
400
```

```text
StudentNotFoundException
  ↓
@ExceptionHandler
  ↓
404
```

```text
Unexpected Exception
  ↓
Generic Handler
  ↓
500
```
