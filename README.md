# Spring Security Example 2

Ví dụ 2: custom login bằng username hoặc email với Spring Boot 4.1.1, Spring Security, MapStruct, Thymeleaf và Layout Dialect.

## Chạy project

1. Chạy `database/create_database.sql` trong SQL Server.
2. Mở `src/main/resources/application.properties`.
3. Sửa `spring.datasource.password=CHANGE_ME` thành mật khẩu SQL Server của bạn.
4. Maven Update Project.
5. Chạy `SpringSecurityExample2Application`.
6. Mở `http://localhost:8081/login`.

Tài khoản mẫu:

- Username: `user01`
- Email: `user01@gmail.com`
- Password: `123456`

Có thể đăng nhập bằng username hoặc email.
