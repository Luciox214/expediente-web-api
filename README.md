# Expediente API  
  
API REST desarrollada con Spring Boot para la búsqueda y consulta de expedientes electrónicos y sus documentos asociados desde una base de datos Oracle. 
  
## Descripción  
  
Esta aplicación proporciona un endpoint HTTP para consultar expedientes almacenados en esquemas Oracle, permitiendo filtrar por año, número, código de repartición y con soporte para paginación. 
  
## Tecnologías  
  
- **Java 17** 
- **Spring Boot 3.5.7** 
- **Spring Boot Starter Web** - Para endpoints REST.
- **Spring Boot Starter JDBC** - Para conectividad con base de datos.
- **Oracle JDBC Driver (ojdbc11)** - Driver para Oracle Database.
- **Maven** - Gestión de dependencias y construcción.
  
## Requisitos Previos  
  
- Java 17 o superior  
- Maven 3.x  
- Acceso a base de datos Oracle con los esquemas apropiados
  
## Configuración  
  
La aplicación requiere las siguientes variables de entorno para la conexión a la base de datos:  
  
```bash  
DB_URL=url
DB_USER=usuario  
DB_PASS=contraseña
