-- =====================================================
-- 02_datos_prueba.sql
-- Ejecutar conectado a la base "control_inventario"
-- =====================================================

-- -----------------------------------------------------
-- 1) Ocho productos válidos
-- El primer INSERT omite la columna "activo" para
-- comprobar el funcionamiento del DEFAULT.
-- -----------------------------------------------------
INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('LAP-001', 'Cuaderno universitario', 'Papelería', 15.50, 40);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo) VALUES
                                                                            ('LAP-002', 'Lapicero azul',         'Papelería',  3.25, 120, TRUE),
                                                                            ('BEB-001', 'Agua pura 600 ml',      'Bebidas',    5.00,  60, TRUE),
                                                                            ('BEB-002', 'Jugo de naranja 1 L',   'Bebidas',   12.75,   2, TRUE),  -- stock entre 1 y 3
                                                                            ('SNK-001', 'Papas fritas grandes',  'Snacks',     9.90,  25, TRUE),
                                                                            ('SNK-002', 'Galletas de chocolate', 'Snacks',     7.40,   0, TRUE),  -- stock igual a 0
                                                                            ('LIM-001', 'Jabón líquido 500 ml',  'Limpieza',  22.00,  15, TRUE),
                                                                            ('LIM-002', 'Desinfectante 1 L',     'Limpieza',  18.60,   3, TRUE);  -- stock entre 1 y 3

-- Comprobación de los productos registrados
SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto
ORDER BY id;

-- -----------------------------------------------------
-- 2) Producto temporal (se eliminará en 03_operaciones.sql)
-- -----------------------------------------------------
INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('TEMP-001', 'Producto de prueba', 'Pruebas', 1.00, 1);

-- -----------------------------------------------------
-- 3) INTENTO INVÁLIDO: código duplicado
-- DEBE FALLAR: viola la restricción uk_producto_codigo
-- (ejecutar esta sentencia por separado)
-- -----------------------------------------------------
INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('LAP-001', 'Cuaderno duplicado', 'Papelería', 16.00, 10);

-- CORRECCIÓN: se utiliza un código que no existe
INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('LAP-003', 'Cuaderno de dibujo', 'Papelería', 16.00, 10);

-- -----------------------------------------------------
-- 4) INTENTO INVÁLIDO: stock negativo
-- DEBE FALLAR: viola la restricción ck_producto_stock
-- (ejecutar esta sentencia por separado)
-- -----------------------------------------------------
INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('SNK-003', 'Maní salado', 'Snacks', 6.50, -5);

-- CORRECCIÓN: se utiliza un stock válido
INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('SNK-003', 'Maní salado', 'Snacks', 6.50, 30);