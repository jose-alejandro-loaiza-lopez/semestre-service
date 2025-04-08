# Microservicio: Semestre

Este microservicio se encarga de la gestión de los semestres académicos.

## 📦 Endpoints REST

Base URL: `/api/v1/semestre-service`

### 🔹 Obtener todos los semestres
```bash
curl -X GET http://localhost:8080/api/v1/semestre-service/semestres
```
### 🔹 Obtener semestres paginados
```bash
curl -X GET http://localhost:8080/api/v1/semestre-service/semestre/page/0
```
### 🔹 Obtener un semestre por ID
```bash
curl -X GET http://localhost:8080/api/v1/semestre-service/semestres/2
```
### 🔹 Crear un semestre
```bash
curl -X POST http://localhost:8080/api/v1/semestre-service/semestres -H "Content-Type: application/json" -d "{"activo":true,"fechaInicio":"2025-01-01","fechaFin":"2025-06-01","idPrograma":2,"numeroSemestre":6}"
```
### 🔹 Actualizar un semestre
```bash
curl -X PUT http://localhost:8080/api/v1/semestre-service/semestres -H "Content-Type: application/json" -d "{"id":2,"activo":true,"fechaInicio":"2025-01-01","fechaFin":"2025-06-01","idPrograma":2,"numeroSemestre":6}"
```
### 🔹 Eliminar un semestre
```bash
curl -X DELETE http://localhost:8080/api/v1/semestre-service/semestres -H "Content-Type: application/json" -d "{"id":2,"activo":true,"fechaInicio":"2025-01-01","fechaFin":"2025-06-01","idPrograma":2,"numeroSemestre":6}"
```

## 🗃️ Modelo de datos

```java
@Entity
@Getter
@Setter
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo 'activo' es obligatorio")
    private Boolean activo;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate fechaFin;

    @NotNull(message = "El ID del programa es obligatorio")
    private Long idPrograma;

    @NotNull(message = "El número de semestre es obligatorio")
    private Long numeroSemestre;
}
```

## 🧪 Datos de prueba (`import.sql`)

```sql
-- Semestres de ejemplo
INSERT INTO semestre (numero_semestre, id_programa, activo, fecha_inicio, fecha_fin) VALUES (1, 1001, TRUE, '2025-01-01', '2025-06-30');
INSERT INTO semestre (numero_semestre, id_programa, activo, fecha_inicio, fecha_fin) VALUES (2, 1001, TRUE, '2025-07-01', '2025-12-15');
INSERT INTO semestre (numero_semestre, id_programa, activo, fecha_inicio, fecha_fin) VALUES (1, 1002, FALSE, '2024-01-15', '2024-06-20');
INSERT INTO semestre (numero_semestre, id_programa, activo, fecha_inicio, fecha_fin) VALUES (3, 1001, TRUE, '2026-01-05', '2026-06-25');
INSERT INTO semestre (numero_semestre, id_programa, activo, fecha_inicio, fecha_fin) VALUES (2, 1003, TRUE, '2025-08-10', '2026-01-15');
```

---
