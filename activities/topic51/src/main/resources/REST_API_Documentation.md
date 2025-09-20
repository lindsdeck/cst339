# Orders Management REST API Documentation

## Endpoint 1

**Title**
Get Orders as JSON

**URL**
/service/getjson

**Method:**
GET

**URL Params**
None

**Data Params**
None

**Success Response:**
Code: 200
Content: 
```json
[
  {
    "id": 1,
    "orderNo": "Order 1",
    "productName": "Product A", 
    "price": 10.99,
    "quantity": 2
  }
]
```

## Endpoint 2

**Title**
Get Orders as XML

**URL**
/service/getxml

**Method:**
GET

**URL Params**
None

**Data Params**
None

**Success Response:**
Code: 200
Content: 
```xml
<orders>
  <orders>
    <id>1</id>
    <orderNo>Order 1</orderNo>
    <productName>Product A</productName>
    <price>10.99</price>
    <quantity>2</quantity>
  </orders>
</orders>