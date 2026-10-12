-- =====================================================
-- 03_operaciones.sql
-- Ejecutar conectado a la base "control_inventario"
-- =====================================================

-- =====================================================
-- PARTE 4. CONSULTAS OBLIGATORIAS
-- =====================================================

-- 1) Mostrar todos los productos
SELECT codigo, nombre, categoria, precio, stock
FROM producto;

-- 2) Buscar los productos de una categoría específica
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE categoria = 'Bebidas';

-- 3) Productos ordenados del precio más alto al más bajo
SELECT codigo, nombre, categoria, precio, stock
FROM producto
ORDER BY precio DESC;

-- 4) Productos con tres unidades o menos
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE stock <= 3;

-- 5) Productos activos que todavía tienen existencias
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE activo = TRUE AND stock > 0;

-- 6) Buscar un producto mediante su código
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE codigo = 'LAP-002';

-- =====================================================
-- PARTE 5. ACTUALIZACIONES Y ELIMINACIÓN
-- =====================================================

-- -----------------------------------------------------
-- A) Simulación de una venta (se venden 2 unidades de BEB-001)
-- -----------------------------------------------------

-- Antes: verificar qué registro será afectado
SELECT codigo, nombre, stock
FROM producto
WHERE codigo = 'BEB-001';

-- Actualización: el nuevo stock se calcula a partir del stock actual
UPDATE producto
SET stock = stock - 2
WHERE codigo = 'BEB-001' AND stock >= 2;

-- Después: comprobar el cambio
SELECT codigo, nombre, stock
FROM producto
WHERE codigo = 'BEB-001';

-- -----------------------------------------------------
-- B) Productos agotados (stock = 0) pasan a inactivos
-- -----------------------------------------------------

-- Antes: verificar qué registros serán afectados
SELECT codigo, nombre, stock, activo
FROM producto
WHERE stock = 0;

-- Actualización
UPDATE producto
SET activo = FALSE
WHERE stock = 0;

-- Después: consultar los productos inactivos
SELECT codigo, nombre, stock, activo
FROM producto
WHERE activo = FALSE;

-- -----------------------------------------------------
-- C) Eliminación del producto temporal TEMP-001
-- -----------------------------------------------------

-- Antes: comprobar que existe
SELECT id, codigo, nombre
FROM producto
WHERE codigo = 'TEMP-001';

-- Eliminación (solo ese registro)
DELETE FROM producto
WHERE codigo = 'TEMP-001';

-- Después: comprobar que ya no existe (debe devolver 0 filas)
SELECT id, codigo, nombre
FROM producto
WHERE codigo = 'TEMP-001';