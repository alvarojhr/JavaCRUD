PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE contactos (
	Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	Identificacion TEXT NOT NULL,
	Nombre TEXT NOT NULL,
	Apellido TEXT NOT NULL,
	Genero TEXT NOT NULL,
	TipoIdentificacion TEXT NOT NULL,
	Telefono TEXT,
	Direccion TEXT,
	Email TEXT
);
DELETE FROM sqlite_sequence;
COMMIT;
