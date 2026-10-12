-- =====================================================
-- 01_creacion.sql
-- Actividad: Control de inventario en PostgreSQL
-- Estudiante: Lilian Hernández
-- =====================================================

-- -----------------------------------------------------
-- PASO A: Creación de la base de datos
-- Ejecutar conectado a la base "postgres"
-- -----------------------------------------------------
CREATE DATABASE control_inventario;

-- -----------------------------------------------------
-- PASO B: Creación de la tabla
-- Ejecutar conectado a la base "control_inventario"
-- -----------------------------------------------------
CREATE TABLE producto (
                          id        BIGINT GENERATED ALWAYS AS IDENTITY,  -- identificador automático
                          codigo    VARCHAR(15)   NOT NULL,
                          nombre    VARCHAR(80)   NOT NULL,
                          categoria VARCHAR(40)   NOT NULL,
                          precio    NUMERIC(8,2)  NOT NULL,
                          stock     INTEGER       NOT NULL,
                          activo    BOOLEAN       NOT NULL DEFAULT TRUE,

                          CONSTRAINT pk_producto        PRIMARY KEY (id),
                          CONSTRAINT uk_producto_codigo UNIQUE (codigo),
                          CONSTRAINT ck_producto_precio CHECK (precio > 0),
                          CONSTRAINT ck_producto_stock  CHECK (stock >= 0)
);

-- -----------------------------------------------------
-- Verificación de la estructura de la tabla
-- -----------------------------------------------------
SELECT column_name, data_type, is_nullable, column_default
FROM information_schema.columns
WHERE table_name = 'producto'
ORDER BY ordinal_position;

-- -----------------------------------------------------
-- Verificación de las restricciones
-- -----------------------------------------------------
SELECT conname, contype, pg_get_constraintdef(oid) AS definicion
FROM pg_constraint
WHERE conrelid = 'producto'::regclass;