# Mini E-commerce Backend

A Spring Boot REST API application for managing shopping carts in an e-commerce system.

## Features

- **Product Management**:
  - View all available products
  - Get product details by ID
- **Shopping Cart Operations**:
  - View all carts
  - View cart by user ID
  - Add items to cart (with quantity)
  - Update item quantities in cart
  - Remove items from cart
- **Cart Item Management**:
  - View all cart items across the system

## Technology Stack

- **Java 21**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **Spring Security** (Basic Authentication)
- **H2 Database** 

## Project Structure

```
src/main/java/com/milica/mini_ecommerce_backend/
 Controller
CartController.java          
CartItemController.java       
ProductController.java      
  Model
Cart.java
CartItem.java
Product.java
  Repository
CartRepository.java
CartItemRepository.java
ProductRepository.java
  Service
CartService.java
CartItemService.java
ProductService.java
```

## Prerequisites

- Java 21
- Git
- No need to install Maven (project uses Maven Wrapper)

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/DjordjevicMilica12/e-commerce.git
cd mini-ecommerce-backend
```

### 2. Build the Project

```bash
mvnw.cmd clean install
```

### 3. Run the Application

```bash
mvnw.cmd spring-boot:run
```

The application will start on `http://localhost:8080`

### 4. Access H2 Database Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:file:./data/miniecom`
- Username: `sa`
- Password:

### 5. API Authentication
All API endpoints require Basic Authentication:
- Username: `admin`
- Password: `admin123`

Example using curl:
```bash
curl -u admin:admin123 http://localhost:8080/api/products
```

## API Endpoints

### Product Operations
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID

### Cart Operations
- `GET /api/cart/all` - Get all carts (admin functionality)
- `GET /api/cart?userId={userId}` - Get cart by user ID
- `POST /api/cart/add?userId={userId}&productId={productId}&quantity={quantity}` - Add item to cart
- `PUT /api/cart/update` - Update cart item quantity (JSON body: cartItemId, quantity)
- `DELETE /api/cart/remove?cartItemId={cartItemId}` - Remove item from cart

### Cart Items
- `GET /api/cartitem` - Get all cart items across the system

## Architecture Decisions

### 1. **Layered Architecture**
- **Controller Layer**: Handles HTTP requests and responses
- **Service Layer**: Contains business logic
- **Repository Layer**: Data access using Spring Data JPA
- **Model Layer**: Entity classes with JPA annotations

### 2. **Database Choice**
- Used H2 file-based database (`./data/miniecom`) for development with data persistence
- Database recreated on each application restart (`ddl-auto=create-drop`)
- H2 console enabled for easy database inspection

### 3. **Security Configuration**
- Basic Authentication enabled for all endpoints
- Admin credentials: `admin/admin123`

## Self-Assessment

### Challenges Faced and Solutions

1. **Learning Spring Boot Ecosystem**
   - **Challenge**: First time working with Spring Boot, Spring Data JPA, and Spring Security
   - **Solution**: Focused on understanding core concepts through documentation and implementing basic functionality step by step

2. **Entity Relationships and JSON Serialization**
   - **Problem**: Infinite recursion when serializing Cart and CartItem entities
   - **Solution**: Used `@JsonManagedReference` and `@JsonBackReference` annotations to handle bidirectional relationships

3. **Time Constraints**
   - **Challenge**: Limited development time due to personal circumstances (final days in Spain, packing, etc.)
   - **Solution**: Prioritized core functionality and implemented a solid foundation that can be extended

### Personal Reflection

This project was my first deep dive into the Spring ecosystem, coming from a C# background. Despite having only a few hours to research and implement this solution due to time constraints, I found Spring Boot incredibly intuitive and powerful. The auto-configuration and overall framework design impressed me greatly.
I hope that completing a functional foundation within such a limited timeframe demonstrates my ability to quickly adapt to new technologies. I believe this initiative showcases my eagerness to learn and grow as a developer. While I know this implementation doesn't fully meet all the specified requirements, I'm confident that given proper time, I would excel at completing all missing features and exploring advanced Spring capabilities.
The experience has definitely sparked my passion for Java/Spring development, and I'm excited about the opportunity to continue expanding my skills in this ecosystem. I hope this project provides insight into my problem-solving approach and dedication to object-oriented programming, and I look forward to demonstrating my full potential with adequate development time.
